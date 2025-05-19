INSERT INTO AUTHORS (ID, AUTHOR_NAME, PASSWORD, EMAIL_ID) VALUES
(1000, 'Sibirajen', '$2a$10$1mPQgnZf72g0TVLC1HVvS.1I7lzg9fND/2U8TT5jzX0hjxPOjyTku', 'sibirajen16@gmail.com'),
(2000, 'Sushma', '$2a$10$1mPQgnZf72g0TVLC1HVvS.1I7lzg9fND/2U8TT5jzX0hjxPOjyTku', 'sushma@gmail.com');

-- Inserting realistic articles related to tech, development, and programming

INSERT INTO ARTICLES (ID, AUTHOR_NAME, AUTHOR_ID, TITLE, CONTENT, CREATE_DATE) VALUES
(1000, 'Sibirajen', 1000, 'The Future of AI in Software Development', 'In this article, we explore how artificial intelligence is transforming the software development industry. From code generation to debugging and automated testing, AI is making its mark in all aspects of development.', '2025-01-15'),
(2000, 'Sibirajen', 1000, 'Why Java is Still Relevant in 2025', 'Java continues to be one of the most used languages in enterprise applications. This article explains why Java remains crucial for backend development and explores its advantages over newer languages.', '2025-02-10'),
(3000, 'Sibirajen', 1000, 'Spring Boot: A Comprehensive Guide for Beginners', 'Spring Boot simplifies the development of Java applications. This guide covers the basics, from setting up your first Spring Boot project to deploying it to the cloud, making it an essential read for beginners.', '2025-03-01'),
(4000, 'Sibirajen', 1000, 'The Importance of Data Structures in Problem Solving', 'Understanding data structures is key to solving complex problems efficiently. This article explains how to approach data structure challenges and improve your algorithmic thinking.', '2025-03-15'),
(5000, 'Sibirajen', 1000, 'Best Practices for Writing Clean Code', 'Writing clean code is essential for maintaining a scalable and understandable codebase. This article shares tips on writing clean, readable, and efficient code, following the SOLID principles.', '2025-04-01'),
(6000, 'Sibirajen', 1000, 'Understanding Microservices Architecture', 'Microservices is an architectural style that structures an application as a collection of loosely coupled services. In this article, we dive deep into the principles, benefits, and challenges of adopting microservices in modern applications.', '2025-04-15'),
(7000, 'Sushma', 2000, 'A Guide to Unit Testing in Java', 'Unit testing is an essential practice for ensuring code reliability and correctness. This article covers the best tools and frameworks for unit testing in Java and provides practical examples.', '2025-05-01'),
(8000, 'Sushma', 2000, 'Mastering Git for Team Collaboration', 'Git is a critical tool for version control and collaboration. This article walks through effective branching strategies, resolving conflicts, and using pull requests in team environments.', '2025-05-05'),
(9000, 'Sushma', 2000, 'REST vs GraphQL: Choosing the Right API Style', 'This article compares REST and GraphQL, highlighting their pros and cons to help developers make informed decisions about API design.', '2025-05-10'),
(10000, 'Sushma', 2000, 'An Introduction to Docker for Developers', 'Docker allows developers to containerize applications and simplify deployment. This article introduces Docker concepts and provides step-by-step setup instructions.', '2025-05-12'),
(11000, 'Sushma', 2000, 'Optimizing Java Performance: Tips and Tools', 'Learn how to profile, monitor, and improve Java application performance using tools like JVisualVM, JFR, and garbage collection tuning.', '2025-05-14'),
(12000, 'Sushma', 2000, 'CI/CD with GitHub Actions', 'This guide introduces GitHub Actions for setting up Continuous Integration and Continuous Deployment workflows directly from your GitHub repositories.', '2025-05-18');
