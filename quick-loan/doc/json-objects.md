


http://localhost:8080/loan/
- all dollar values are string to avoid double overflow issues w/ large values
- this is the top level list, all fields but `payments` can be modified/edited
- `loanMethodType` and `loanPeriodType` codes are from lookup endpoints below.
- `payments` is null in this listing
```
[
  {
    "id": "c21ced99-bdc0-46f4-0002-990a8b3b2c72",
    "name": "example monthly loan",
    "description": "a second monthly loan",
    "rate": 0.04325,
    "amount": "12,500.00",
    "fundsDisbursementDate": "2023-11-15",
    "firstStatementDate": "2024-02-15",
    "firstInterestPaymentDate": "2024-02-15",
    "firstPrincipalPaymentDate": "2025-02-15",
    "currentMaturityDate": "2029-02-15",
    "finalMaturityDate": "2029-02-15",
    "loanMethodType": "SL",
    "loanPeriodType": "M",
    "payments": null
  },
  {
    "id": "c21ced99-bdc0-46f4-0003-990a8b3b2c72",
    "name": "complex loan",
    "description": "a very complex loan",
    "rate": 0.03825,
    "amount": "150,000.00",
    "fundsDisbursementDate": "2022-08-05",
    "firstStatementDate": "2022-09-22",
    "firstInterestPaymentDate": "2023-02-11",
    "firstPrincipalPaymentDate": "2023-05-17",
    "currentMaturityDate": "2025-04-01",
    "finalMaturityDate": "2027-02-15",
    "loanMethodType": "SL",
    "loanPeriodType": "M",
    "payments": null
  },
  {
    "id": "c21ced99-bdc0-46f4-0001-990a8b3b2c72",
    "name": "example loan",
    "description": "a first loan",
    "rate": 0.04325,
    "amount": "12,500.00",
    "fundsDisbursementDate": "2023-11-15",
    "firstStatementDate": "2024-02-15",
    "firstInterestPaymentDate": "2024-02-15",
    "firstPrincipalPaymentDate": "2024-02-15",
    "currentMaturityDate": "2029-02-15",
    "finalMaturityDate": "2029-02-15",
    "loanMethodType": "SL",
    "loanPeriodType": "Q",
    "payments": null
  }
]
```

http://localhost:8080/loan/c21ced99-bdc0-46f4-0003-990a8b3b2c72
- inital loans are hardcoded uuid values now, so stable
- GET return shown
- PUT/POST for the everything but the `payments` which are calculated
- PUT /loan/{:loanUuid}
- POST /loan
- DELETE works, no body needed
- See: quick-loan/src/main/java/pks/example/quick/infrastructure/rest/LoanController.java
- `loanMethodType` and `loanPeriodType` codes are from lookup endpoints below.
- `payments` is the detail list of information for the loan, not directly editable
- first payment is really the start date or the loan ( customer gets loan funds )
```
{
  "id": "c21ced99-bdc0-46f4-0001-990a8b3b2c72",
  "name": "example loan",
  "description": "a first loan",
  "rate": 0.04325,
  "amount": "12,500.00",
  "fundsDisbursementDate": "2023-11-15",
  "firstStatementDate": "2024-02-15",
  "firstInterestPaymentDate": "2024-02-15",
  "firstPrincipalPaymentDate": "2024-02-15",
  "currentMaturityDate": "2029-02-15",
  "finalMaturityDate": "2029-02-15",
  "loanMethodType": "SL",
  "loanPeriodType": "Q",
  "payments": [
    {
      "date": "2023-11-15",
      "amount": "",
      "interest": "0.00",
      "principal": ""
    },
    {
      "date": "2024-02-15",
      "amount": "668.63",
      "interest": "136.27",
      "principal": "532.37"
    },
    {
      "date": "2024-05-15",
      "amount": "668.63",
      "interest": "127.63",
      "principal": "541.00"
    },
    {
      "date": "2024-08-15",
      "amount": "668.63",
      "interest": "124.57",
      "principal": "544.07"
    },
    {
      "date": "2024-11-15",
      "amount": "668.63",
      "interest": "118.63",
      "principal": "550.00"
    },
    {
      "date": "2025-02-15",
      "amount": "668.63",
      "interest": "112.64",
      "principal": "555.99"
    },
    {
      "date": "2025-05-15",
      "amount": "668.63",
      "interest": "103.10",
      "principal": "565.53"
    },
    {
      "date": "2025-08-15",
      "amount": "668.63",
      "interest": "100.41",
      "principal": "568.22"
    },
    {
      "date": "2025-11-15",
      "amount": "668.63",
      "interest": "94.22",
      "principal": "574.41"
    },
    {
      "date": "2026-02-15",
      "amount": "668.63",
      "interest": "87.96",
      "principal": "580.68"
    },
    {
      "date": "2026-05-15",
      "amount": "668.63",
      "interest": "78.96",
      "principal": "589.67"
    },
    {
      "date": "2026-08-15",
      "amount": "668.63",
      "interest": "75.20",
      "principal": "593.43"
    },
    {
      "date": "2026-11-15",
      "amount": "668.63",
      "interest": "68.73",
      "principal": "599.90"
    },
    {
      "date": "2027-02-15",
      "amount": "668.63",
      "interest": "62.19",
      "principal": "606.44"
    },
    {
      "date": "2027-05-15",
      "amount": "668.63",
      "interest": "53.77",
      "principal": "614.87"
    },
    {
      "date": "2027-08-15",
      "amount": "668.63",
      "interest": "48.88",
      "principal": "619.76"
    },
    {
      "date": "2027-11-15",
      "amount": "668.63",
      "interest": "42.12",
      "principal": "626.51"
    },
    {
      "date": "2028-02-15",
      "amount": "668.63",
      "interest": "35.29",
      "principal": "633.34"
    },
    {
      "date": "2028-05-15",
      "amount": "668.63",
      "interest": "27.77",
      "principal": "640.86"
    },
    {
      "date": "2028-08-15",
      "amount": "668.63",
      "interest": "21.40",
      "principal": "647.23"
    },
    {
      "date": "2028-11-15",
      "amount": "668.63",
      "interest": "14.34",
      "principal": "654.29"
    }
  ]
}
```

http://localhost:8080/loan/type/method
- new url
- GET only as this is defined by Java code.
- `code` is the id value to use, using `code` as at FFB this is a real documented code value
```
[
  {
    "code": "SL",
    "name": "Simple Level Payment Amortization",
    "description": "A simple loan repayment schedule where the periodic payments are the same amount. "
  },
  {
    "code": "SP",
    "name": "Level Principal Payment Amortization",
    "description": "A loan repayment schedule where the periodic payments retire equal principal amounts.  Therefore, the payments get smaller as you get nearer the end of the loan as the interest portion of the payment decreases. "
  }
]
```

http://localhost:8080/loan/type/period
- new url
- GET only as this is defined by Java code.
- `code` is the id value to use, using `code` as at FFB this is a real documented code value
```
[
  {
    "code": "M",
    "name": "Monthly",
    "description": "A monthly payment schedule."
  },
  {
    "code": "Q",
    "name": "Quarterly",
    "description": "A quarterly payment schedule."
  }
]
```

http://localhost:8080/loan/setting/interest-rate
- GET and then POST
- defined but not used since the rate is passed in via the loan object/endpoint as well
```
{
  "rate": 0.045
}
```