
========================
Selenium-Java_Framework
========================


I am continually learning and striving to transition from a manual tester to an automation engineer. With over 14 years of experience in manual testing, I’ve faced increasing challenges in finding work in Poland since 2023, as manual testers are often undervalued. Despite searching for over a year, I remain determined to upskill and build a career in automation testing. This repository is a significant milestone in my journey, showcasing my progress and dedication to mastering automation frameworks.

Automated Testing on Saucedemo Website

This repository demonstrates my approach to automating key functionalities on the Saucedemo website using Selenium and Java. The framework covers core actions such as logging in, navigating pages, interacting with dropdowns, and managing the shopping cart.




=======================================================
Commit 1: Initial Commit (Driver Management and Login)
=======================================================

Date: Initial Commit

About the Initial Version:

	•	Implemented the core functionality:
	•	Driver Management:
	•	Created a class to manage the WebDriver setup and initialization.
	•	Used get() to navigate to the desired URL.
	•	User Login:
	•	Developed functionality to log into the website using predefined credentials.
	•	Implemented basic error handling to ensure interactions are reliable.

Highlights:
	•	Test URL: https://www.saucedemo.com
	•	Classes Introduced:
	•	A dedicated class for browser management and handling the login process.





========================================================================
Commit 2: 4.12.2024 (Advanced Navigation, Dropdown, and Cart Management)
========================================================================

Current Status:

Enhancements Added:
	•	Page Navigation:
	•	Implemented back navigation using driver.navigate().back() to ensure smooth movement between pages.
	•	Added functionality to wait for the page to reload fully after navigation.
	•	Cart Management:
	•	Added functionality to manage the shopping cart, including adding multiple items and waiting for elements to load before interacting with them.
	•	Dropdown Filtering:
	•	Integrated dropdown selection using value, index, and visible text to filter items.

Challenges and Solutions:

	•	Dynamic Elements:
	•	Handled elements that change positions or states dynamically using advanced XPath and explicit waits.
	•	Loading Delays:
	•	Utilized WebDriverWait to ensure elements are available before performing actions.
	•	Back Navigation:
	•	Ensured consistent state and proper reloading of the page after using navigate().back().

Next Steps:

	1.	Assertions:
	•	Enhance the framework by adding more robust assertions to verify critical aspects, such as cart totals and applied filters.
	2.	Advanced Scenarios:
	•	Expand the framework to include support for handling pop-ups, frames, and dynamic content such as AJAX elements.
	3.	Error Handling:
	•	Refine exception handling to improve the clarity and usability of logs.
	4.	Framework Selection:
	•	I plan to incorporate a more structured framework for better test management and scalability. However, I am still exploring the best approach, considering:
	•	TestNG: For grouping and advanced test case management.
	•	JUnit: For simplicity and seamless integration with Maven/Gradle.
	•	Cucumber: For creating human-readable test scenarios using BDD.

Closing Note:

This project marks a significant step in my journey toward mastering test automation frameworks. Starting with the basics like login and driver management, I expanded it to cover page navigation, dropdown filtering, and cart management. While there’s still room for improvement, this repository demonstrates a modular and scalable approach to test automation.

Thank you for visiting this repository, and I welcome any feedback or suggestions for further improvements! 😊
