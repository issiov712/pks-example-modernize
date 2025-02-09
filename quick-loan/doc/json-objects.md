


http://localhost:8080/loan/
- all dollar values are string to avoid double overflow issues w/ large values
```
[
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
]
```

http://localhost:8080/loan/c21ced99-bdc0-46f4-0003-990a8b3b2c72
- inital loans are hardcoded uuid values now, so stable
```
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
  "payments": [
    {
      "date": "2022-08-05",
      "amount": "",
      "interest": "0.00",
      "principal": ""
    },
    {
      "date": "2022-09-05",
      "amount": "0.00",
      "interest": "487.29",
      "principal": "0.00"
    },
    {
      "date": "2022-09-22",
      "amount": "0.00",
      "interest": "268.09",
      "principal": "0.00"
    },
    {
      "date": "2022-10-22",
      "amount": "0.00",
      "interest": "473.95",
      "principal": "0.00"
    },
    {
      "date": "2022-11-22",
      "amount": "0.00",
      "interest": "491.29",
      "principal": "0.00"
    },
    {
      "date": "2022-12-22",
      "amount": "0.00",
      "interest": "476.98",
      "principal": "0.00"
    },
    {
      "date": "2023-01-22",
      "amount": "0.00",
      "interest": "494.43",
      "principal": "0.00"
    },
    {
      "date": "2023-02-11",
      "amount": "320.03",
      "interest": "320.03",
      "principal": "0.00"
    },
    {
      "date": "2023-03-11",
      "amount": "448.04",
      "interest": "448.04",
      "principal": "0.00"
    },
    {
      "date": "2023-04-11",
      "amount": "496.04",
      "interest": "496.04",
      "principal": "0.00"
    },
    {
      "date": "2023-05-11",
      "amount": "480.04",
      "interest": "480.04",
      "principal": "0.00"
    },
    {
      "date": "2023-05-17",
      "amount": "3,492.05",
      "interest": "96.01",
      "principal": "704.00"
    },
    {
      "date": "2023-06-17",
      "amount": "3,492.05",
      "interest": "485.01",
      "principal": "3,007.04"
    },
    {
      "date": "2023-07-17",
      "amount": "3,492.05",
      "interest": "459.91",
      "principal": "3,032.14"
    },
    {
      "date": "2023-08-17",
      "amount": "3,492.05",
      "interest": "465.39",
      "principal": "3,026.66"
    },
    {
      "date": "2023-09-17",
      "amount": "3,492.05",
      "interest": "455.56",
      "principal": "3,036.49"
    },
    {
      "date": "2023-10-17",
      "amount": "3,492.05",
      "interest": "431.31",
      "principal": "3,060.74"
    },
    {
      "date": "2023-11-17",
      "amount": "3,492.05",
      "interest": "435.75",
      "principal": "3,056.30"
    },
    {
      "date": "2023-12-17",
      "amount": "3,492.05",
      "interest": "412.08",
      "principal": "3,079.97"
    },
    {
      "date": "2024-01-17",
      "amount": "3,492.05",
      "interest": "415.81",
      "principal": "3,076.24"
    },
    {
      "date": "2024-02-17",
      "amount": "3,492.05",
      "interest": "405.82",
      "principal": "3,086.23"
    },
    {
      "date": "2024-03-17",
      "amount": "3,492.05",
      "interest": "370.26",
      "principal": "3,121.79"
    },
    {
      "date": "2024-04-17",
      "amount": "3,492.05",
      "interest": "385.65",
      "principal": "3,106.40"
    },
    {
      "date": "2024-05-17",
      "amount": "3,492.05",
      "interest": "363.45",
      "principal": "3,128.60"
    },
    {
      "date": "2024-06-17",
      "amount": "3,492.05",
      "interest": "365.40",
      "principal": "3,126.65"
    },
    {
      "date": "2024-07-17",
      "amount": "3,492.05",
      "interest": "343.78",
      "principal": "3,148.27"
    },
    {
      "date": "2024-08-17",
      "amount": "3,492.05",
      "interest": "345.01",
      "principal": "3,147.04"
    },
    {
      "date": "2024-09-17",
      "amount": "3,492.05",
      "interest": "334.79",
      "principal": "3,157.26"
    },
    {
      "date": "2024-10-17",
      "amount": "3,492.05",
      "interest": "314.06",
      "principal": "3,177.99"
    },
    {
      "date": "2024-11-17",
      "amount": "3,492.05",
      "interest": "314.21",
      "principal": "3,177.84"
    },
    {
      "date": "2024-12-17",
      "amount": "3,492.05",
      "interest": "294.08",
      "principal": "3,197.97"
    },
    {
      "date": "2025-01-17",
      "amount": "3,492.05",
      "interest": "293.50",
      "principal": "3,198.56"
    },
    {
      "date": "2025-02-17",
      "amount": "3,492.05",
      "interest": "283.10",
      "principal": "3,208.95"
    },
    {
      "date": "2025-03-17",
      "amount": "3,492.05",
      "interest": "246.29",
      "principal": "3,245.76"
    }
  ]
}
```

http://localhost:8080/loan/type/method
- new url
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