# Selenium Full-Page Screenshot Demo

A small Selenium + TestNG demo showing how to capture **full-page screenshots** using **AShot**, convert them to **Base64 strings**, and embed them into **Extent Reports**. Great for demonstrating automated visual reporting in web tests.

---

## Features

- Capture **vertical full-page screenshots** of web pages using AShot.
- Convert screenshots to **Base64** for embedding directly in HTML reports.
- Log screenshots in **Extent Reports** for easy test reporting.
- Demonstrates **Page Object Model (POM)** and clean Selenium utilities.

---

## Project Structure

fullpage-screenshot-demo/
│
├─ src/main/java/
│ ├─ pages/
│ │ └─ PracticeHomePage.java # Page Object Model for demo site
│ ├─ utils/
│ │ ├─ ScreenshotUtil.java # Capture + Base64 + log helper
│ │ └─ SeleniumUtils.java # Wait helper methods
│
├─ src/test/java/
│ └─ tests/
│ └─ PracticeHomePageScreenshotTest.java # TestNG test class
│
├─ pom.xml # Maven dependencies

---

## Getting Started

1. **Clone the repository:**
```bash
git clone https://github.com/My3Hub/selenium-fullpage-screenshot.git
Install dependencies:
Make sure you have Maven and Java installed. All dependencies are in pom.xml.

2. **Run the test:**
Execute the TestNG test PracticeHomePageScreenshotTest.java.

3. **View the report:**
Open the generated Extent Report at:
target/extent-reports/spark/index.html
You will see the full-page screenshot embedded as a Base64 image.


