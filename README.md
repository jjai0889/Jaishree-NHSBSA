# Jaishree-NHSBSA
Project Name
NHS Jobs Search Automation - BDD Framework using Cucumber, Selenium, and Java
________________________________________
📚 Project Description
This project automates the job search functionality on the NHS Jobs website using Selenium WebDriver, Cucumber (BDD), Java, and Maven.
It includes:
•	Searching for jobs based on keywords and location.
•	Verifying that job results are sorted by the newest postings.
•	Cross-browser testing using Scenario Outline with Chrome and Firefox.
________________________________________
🛠️ Technologies Used
•	Java
•	Selenium WebDriver
•	Cucumber (BDD)
•	Maven
•	JUnit
•	Eclipse (or any Java IDE)
•	Google Chrome & Mozilla Firefox
________________________________________
📂 Project Structure
text
CopyEdit
project-root/
├── src/
│   ├── main/java/
│   └── test/java/
│       ├── features/
│       │   └── NHSJobSearch.feature
│       ├── stepDefinitions/
│       │   └── StepDefinitions.java
│       └── runners/
│           └── TestRunner.java
├── pom.xml
└── README.md
________________________________________
✅ Prerequisites
•	Java JDK 8 or higher
•	Maven installed and configured in your system's PATH
•	Eclipse or any compatible Java IDE
•	ChromeDriver and GeckoDriver set up in your system (or WebDriverManager configured)
________________________________________
📝 Test Scenarios Covered
•	Search for jobs and sort by newest:
o	Searches jobs based on "Testing" and "London".
o	Verifies that results are sorted by "Date posted (newest)".
o	Prints the top job posting date.
•	Cross-browser compatibility:
o	Runs the same test on Chrome and Firefox using Scenario Outline.
________________________________________

🔍 Notes
•	Make sure browser drivers are correctly configured in your system or project.
•	The project can be extended with tags for selective execution.
•	You can integrate the project with Jenkins for CI/CD.
________________________________________
👤 Author
Your Name
your.JJai0889@gmail.com

