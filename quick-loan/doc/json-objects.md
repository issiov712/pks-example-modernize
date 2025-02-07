


http://localhost:8080/loan/
```
[
  {
    "id": "d6acb690-7fa2-4594-870e-93ba6abef1da",
    "name": "example loan # 2",
    "description": "a second loan to check",
    "amount": {
      "number": 15000,
      "currency": "USD"
    },
    "fundsDisbursementDate": "2021-01-15",
    "firstInterestPaymentDate": "2021-02-19",
    "firstPrincipalPaymentDate": "2021-02-19",
    "currentMaturityDate": "2027-07-19",
    "finalMaturityDate": "2027-07-19",
    "payments": [
      {
        "date": "2027-07-19",
        "amount": {
          "number": 100,
          "currency": "USD"
        },
        "interest": {
          "number": 100,
          "currency": "USD"
        },
        "principal": {
          "number": 100,
          "currency": "USD"
        }
      }
    ]
  },
  {
    "id": "32dfbfe7-957e-4655-b1e7-48d4594df3b3",
    "name": "example loan",
    "description": "a first loan",
    "amount": {
      "number": 37500,
      "currency": "USD"
    },
    "fundsDisbursementDate": "2023-11-21",
    "firstInterestPaymentDate": "2023-12-12",
    "firstPrincipalPaymentDate": "2024-12-12",
    "currentMaturityDate": "2029-07-12",
    "finalMaturityDate": "2033-07-12",
    "payments": [
      {
        "date": "2029-07-12",
        "amount": {
          "number": 100,
          "currency": "USD"
        },
        "interest": {
          "number": 100,
          "currency": "USD"
        },
        "principal": {
          "number": 100,
          "currency": "USD"
        }
      }
    ]
  }
]
```

http://localhost:8080/loan/d6acb690-7fa2-4594-870e-93ba6abef1da
```
{
  "id": "d6acb690-7fa2-4594-870e-93ba6abef1da",
  "name": "example loan # 2",
  "description": "a second loan to check",
  "amount": {
    "number": 15000,
    "currency": "USD"
  },
  "fundsDisbursementDate": "2021-01-15",
  "firstInterestPaymentDate": "2021-02-19",
  "firstPrincipalPaymentDate": "2021-02-19",
  "currentMaturityDate": "2027-07-19",
  "finalMaturityDate": "2027-07-19",
  "payments": [
    {
      "date": "2027-07-19",
      "amount": {
        "number": 100,
        "currency": "USD"
      },
      "interest": {
        "number": 100,
        "currency": "USD"
      },
      "principal": {
        "number": 100,
        "currency": "USD"
      }
    }
  ]
}
```

http://localhost:8080/loan/calculationTypes
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

http://localhost:8080/loan/periodTypes
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