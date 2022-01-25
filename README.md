# Mood Tracker

## Description

Mood Tracker is a colorful and responsive calendar that can be used as a personal journal and for tracking moods. Simply click a day in your calendar to set the mood and describe your thoughts on that day! The first line of your description will serve as a preview on the front face of your calendar for that day.

## Preview

<img width="1059" alt="Screen Shot 2022-01-25 at 1 06 23 PM" src="https://user-images.githubusercontent.com/3468354/151052124-7f29dfdf-9ae1-43d2-a1ba-67aee038fbd2.png">
<img width="1059" alt="Screen Shot 2022-01-25 at 1 06 56 PM" src="https://user-images.githubusercontent.com/3468354/151052165-25b54070-f89e-431c-b8e7-dd22153fe3c0.png">

## API

`Content-Type: application/json`

|Method|URI|Response|Request Body|Purpose|
|-|-|-|-|-|
|GET|/api/users|List\<User\>|-|Gets all users.|
|GET|/api/users/:id/moods|List\<Mood\>|-|Get all moods for a user|
|PUT|/api/users/:id/moods|-|Mood|Creates or updates a mood|

## Types
```ts
interface User {
    id:         number;
    name:       string;
    password:   string; // salt+hashed
    role:       string; // 'user'|'admin'
    enabled:    boolean;
    created_on: datetime;
    updated_on: datetime;
}

interface Mood {
    id:         string; // yyyy-MM-dd
    user_id:    number;
    value:      number; // Interval: [0, 4]
    description:string;
}
```

## Schema

<img width="385" alt="Screen Shot 2022-01-25 at 1 07 33 PM" src="https://user-images.githubusercontent.com/3468354/151052230-adadc0c8-82bc-42f3-bfda-00ac07fabfdb.png">

## Technologies

- `Angular` (Frontend Framework)
- `Spring Boot` (Backend Framework)
- `Spring Security` (Access Control)
- `Spring JPA` (Data Persistence)
- `Hibernate` (ORM)
- `MySQL` (DBMS)
- `Tomcat` (Webserver)
- `Gradle` (Build automation)
- `JUnit` (Testing)
- `Lombok` (Library)
