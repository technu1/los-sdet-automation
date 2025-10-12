# 📦 Project: LOS SDET Automation (Java • TestNG • Maven • Cucumber • Rest-Assured)
│ └─ test/
│ ├─ java/
│ │ └─ com/bank/los/
│ │ ├─ runners/
│ │ │ ├─ CucumberSmokeRunner.java
│ │ │ └─ CucumberRegressionRunner.java
│ │ ├─ steps/
│ │ │ ├─ LoanSteps.java
│ │ │ └─ Hooks.java
│ │ └─ support/
│ │ ├─ World.java
│ │ └─ RetryAnalyzer.java
│ └─ resources/
│ ├─ features/
│ │ └─ loan_application.feature
│ ├─ wiremock/
│ │ └─ mappings/
│ │ ├─ credit-bureau-200.json
│ │ └─ funding-201.json
│ └─ config/
│ ├─ local.properties
│ ├─ dev.properties
│ └─ qa.properties
└─ tools/
└─ scripts/
├─ run-wiremock.sh
└─ seed-test-data.sql
```


---