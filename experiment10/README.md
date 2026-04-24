# Experiment 10 - CRUD Operations using Node.js + Express.js

## Overview
This project demonstrates CRUD (Create, Read, Update, Delete) operations on a MongoDB database using Node.js and Express.js as the backend framework.

## Tech Stack
- **Node.js** - Runtime environment
- **Express.js** - Web framework for building REST APIs
- **MongoDB** - NoSQL database for storing records
- **Mongoose** - ODM library for MongoDB
- **Postman** - API testing tool

## Project Structure
```
experiment10/
├── server.js               # Entry point - Express server & DB connection
├── models/
│   └── Student.js          # Mongoose schema/model for Student
├── routes/
│   └── studentRoutes.js    # All CRUD route handlers
├── package.json
└── README.md
```

## Installation & Setup

1. Make sure **MongoDB** is running locally on port `27017`
2. Install dependencies:
```bash
npm install
```
3. Start the server:
```bash
npm run dev       # with nodemon (auto-restart)
# or
npm start         # normal start
```
4. Server runs at: `http://localhost:5000`

## API Endpoints

| Method | Endpoint              | Description          |
|--------|-----------------------|----------------------|
| POST   | /api/students         | Create a new student |
| GET    | /api/students         | Get all students     |
| GET    | /api/students/:id     | Get student by ID    |
| PUT    | /api/students/:id     | Update student by ID |
| DELETE | /api/students/:id     | Delete student by ID |

## API Testing with Postman

### Create Record
```
POST http://localhost:5000/api/students
Content-Type: application/json

{
  "name": "Rahul",
  "email": "rahul@gmail.com",
  "course": "BCA"
}
```

### Get All Records
```
GET http://localhost:5000/api/students
```

### Get Single Record
```
GET http://localhost:5000/api/students/<id>
```

### Update Record
```
PUT http://localhost:5000/api/students/<id>
Content-Type: application/json

{
  "name": "Rahul Kumar",
  "email": "rahul.kumar@gmail.com",
  "course": "MCA"
}
```

### Delete Record
```
DELETE http://localhost:5000/api/students/<id>
```

## How It Works
- **Node.js & Express.js** handle HTTP requests and routing
- **MongoDB** stores all student records persistently
- **Mongoose** provides schema validation and database interaction
- **CORS** is enabled to allow cross-origin requests
- All routes include error handling for robustness
