'use client';

import { Grid, GridColumn } from '@progress/kendo-react-grid';
import { useParams } from 'next/navigation';
import useSWR from 'swr';


const fetcher = (url: any) => fetch(url).then((r) => r.json())

interface LoanPayment {
	date: string;
	amount: string;
	interest: string;
	principal: string;
}

interface Loan {
	name: string;
	payments: LoanPayment[];
}

export default function LoanContent() {
	console.log('entering LoanContent')

	const params = useParams<{ id: string; }>()

	const { data, error, isLoading } = useSWR(`http://localhost:8080/loan/${params.id}`, fetcher, { refreshInterval: 1000 })

	if (isLoading) return(<></>);
	if (error) return( <>Error: {error.message}</>);

	return(
		<>
			<h1>Loan Id: {params.id}</h1>
			<ul>
				{data.payments.map((payments: { date: string, amount: string, interest: string, principal: string }) => { 
					console.log('date:', payments.date);
					return(<li key={payments.date}>{payments.date} / {payments.amount} / {payments.interest}  / {payments.principal} </li>
				)})}
			</ul>

			{/* <Grid>
				<GridColumn>

				</GridColumn>
			</Grid> */}
		</>
	)
};
