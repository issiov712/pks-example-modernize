// import React from 'react';
import * as React from 'react';
import { Button } from '@progress/kendo-react-buttons';
import { Calendar } from '@progress/kendo-react-dateinputs';
import { Grid, GridColumn, GridSortChangeEvent, GridToolbar } from '@progress/kendo-react-grid';
import { Label } from '@progress/kendo-react-labels';
import { process, orderBy, filterBy, SortDescriptor } from '@progress/kendo-data-query';
import { ExcelExport } from '@progress/kendo-react-excel-export';
import { Checkbox } from '@progress/kendo-react-inputs';
import { LoanType, PaymentType } from './gd-interfaces';
import { AppBar, AppBarSection, AppBarSpacer } from '@progress/kendo-react-layout';
import { menuIcon } from '@progress/kendo-svg-icons';
import { Input } from '@progress/kendo-react-inputs';
import kendoka from './kendoka.svg';
import './App.scss';

//function App() {

const App = () => {

	const handleClick = React.useCallback(() => {
    	window.open('https://www.telerik.com/kendo-react-ui/components/', '_blank');
	}, []);

	const [loans, setLoans] = React.useState<LoanType[]>([]);
	const [payments, setPayments] = React.useState<PaymentType[]>([]);
    const [sort, setSort] = React.useState<Array<SortDescriptor>>([{ field: 'name', dir: 'desc' }]);
    const [allowUnsort, setAllowUnsort] = React.useState<boolean>(true);
    const [multiple, setMultiple] = React.useState<boolean>(false);

    const sortChange = (event: GridSortChangeEvent) => {
        setLoans(getLoans(event.sort));
        setSort(event.sort);
    };

	const getLoans = (sort: SortDescriptor[]): LoanType[] => {
		return orderBy(loans, sort);
	}

	React.useEffect(() => {
		fetch('http://localhost:8080/loan/')
			.then((response) => response.json())
			.then(setLoans);
  	}, []);

	React.useEffect(() => {
		fetch('http://localhost:8080/loan/c21ced99-bdc0-46f4-0003-990a8b3b2c72')
			.then((response) => response.json())
			.then(setPayments);
  	}, []);

	const _export = React.useRef<ExcelExport | null>(null);
	const excelExport = () => {
		if (_export.current !== null) {
			_export.current.save();
		}
	};

	return(
		<React.Fragment>
		<AppBar>
		<AppBarSection>
			<Button type="button" fillMode="flat" svgIcon={menuIcon} />
		</AppBarSection>

		<AppBarSpacer style={{ width: 4 }} />

		<AppBarSection>
			<h1 className="title">Multi-Client Loan System (MCLS)</h1>
		</AppBarSection>

		<AppBarSpacer style={{ width: 32 }} />

		<AppBarSection>
			<Input placeholder="Search" />
		</AppBarSection>
	</AppBar>
		<div className="App">
			<h1>Hellow KendoReact!</h1>
			<Calendar />
			<ExcelExport data={loans} ref={_export}>
			<Grid 
				data={loans}
			    sortable={{
					allowUnsort: allowUnsort,
					mode: multiple ? 'multiple' : 'single'
				}}
				sort={sort}
				onSortChange={sortChange}
			>
                <GridToolbar>
                    <Button title="Export Excel" themeColor={'primary'} type="button" onClick={excelExport}>
                        Export to Excel
                    </Button>
                </GridToolbar>
				<GridColumn field="name" />
				<GridColumn field="description" />
				<GridColumn field="UnitsInStock" />
				<GridColumn field="Discontinued" />
			</Grid>
			</ExcelExport>

			<ExcelExport data={payments} ref={_export}>
			<Grid 
				data={payments}
			    sortable={{
					allowUnsort: allowUnsort,
					mode: multiple ? 'multiple' : 'single'
				}}
				sort={sort}
				onSortChange={sortChange}
			>
                <GridToolbar>
                    <Button title="Export Excel" themeColor={'primary'} type="button" onClick={excelExport}>
                        Export to Excel
                    </Button>
                </GridToolbar>

				<GridColumn field="Date" />
				<GridColumn field="Payment" />
				<GridColumn field="Interest" />
				<GridColumn field="Principal" />
			</Grid>
			</ExcelExport>
		</div>
		</React.Fragment>
  	);

};

export default App;

/*
  return (
    <div className="App">

      <header className="App-header">
        <img src={kendoka} className="App-logo" alt="kendoka" />
        <p>
          Edit <code>src/App.tsx</code> and save to reload.
        </p>
        <Button
          themeColor={'primary'}
          size={"large"}
          onClick={handleClick}
        >
          Learn KendoReact
        </Button>
      </header>

    </div>
  );
*/

