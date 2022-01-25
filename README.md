# Mood Tracker

## Description

Mood Tracker is a colorful and responsive calendar that can be used as a personal journal and for tracking moods. Simply click a day in your calendar to set the mood and describe your thoughts on that day! The first line of your description will serve as a preview on the front face of your calendar for that day.

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