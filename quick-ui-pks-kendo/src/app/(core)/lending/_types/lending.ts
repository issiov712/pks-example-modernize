export interface LoanType {
	id: string;
	name: string;
	description: string;
	rate: number;
	amount: BigInt;
	fundsDisbursementDate: Date;
};

export interface RepaymentType {
	date: Date;
	amount: BigInt;
	interest: BigInt;
	principal: BigInt;
}