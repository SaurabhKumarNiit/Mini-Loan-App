# MiniLoanApp

## Introduction

MiniLoanApp is a web application designed to streamline the process of applying for loans. It consists of both backend and frontend components that work together to provide a user-friendly experience. This README provides instructions on how to set up and run the application.

## Backend Setup

The backend of MiniLoanApp uses MySQL as its database. Before running the application, make sure you have MySQL services enabled on your system.

### IDE
You can use any Integrated Development Environment (IDE) of your choice. The README assumes the use of IntelliJ IDEA.

1. Open your IDE (IntelliJ IDEA recommended).

2. Run each microservice.

## Frontend Setup

The frontend of MiniLoanApp is developed using Angular and is intended to be run in Visual Studio Code (VS Code).

### Prerequisites
Make sure you have Node.js and npm (Node Package Manager) installed on your system.

### Installation

1. Open your terminal.

2. Navigate to the frontend directory of MiniLoanApp.

```shell
cd frontend
```

3. Install all the necessary dependencies by running the following command:

```shell
npm install
```

### Running the Application

1. Once the dependencies are installed, you can start the Angular CLI development server by running:

```shell
ng start -o
```

You can also use the shortcut:

```shell
ng s -o
```

2. This will automatically open your default web browser and navigate to the application. You will be prompted to log in.

3. If you haven't registered yet, you will need to complete the registration process first.

4. After successfully logging in, you will land on the home page where you can find the "Apply Now" option to begin your loan application.

## Conclusion

MiniLoanApp simplifies the loan application process by combining backend microservices with a user-friendly Angular frontend. By following the setup instructions provided in this README, you can quickly get the application up and running on your system.

For any further assistance or inquiries, please feel free to reach out to the project maintainers. Thank you for using MiniLoanApp!