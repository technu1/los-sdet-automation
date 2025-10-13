# LOS SDET Automation

[![Allure Report](https://img.shields.io/badge/Allure-Report-3B5998?style=flat&logo=allure&logoColor=white)](https://technu1.github.io/los-sdet-automation/)

Automated end-to-end testing framework for LOS (Loan Origination System)  
**Tech stack:** Java • TestNG • Cucumber • RestAssured • Maven • Allure • GitHub Actions CI
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