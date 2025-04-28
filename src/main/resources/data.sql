INSERT INTO AUTHORS (ID, AUTHOR_NAME, PASSWORD, EMAIL_ID) VALUES
(1000, 'Sibirajen', '$2a$10$1mPQgnZf72g0TVLC1HVvS.1I7lzg9fND/2U8TT5jzX0hjxPOjyTku', 'sibirajen16@gmail.com');

-- Inserting realistic articles related to tech, development, and programming

INSERT INTO ARTICLES (ID, AUTHOR_NAME, AUTHOR_ID, TITLE, CONTENT, CREATE_DATE) VALUES
(1000, 'Sibirajen', 1000, 'The Future of AI in Software Development', 'In this article, we explore how artificial intelligence is transforming the software development industry. From code generation to debugging and automated testing, AI is making its mark in all aspects of development.', NOW()),
(2000, 'Sibirajen', 1000, 'Why Java is Still Relevant in 2025', 'Java continues to be one of the most used languages in enterprise applications. This article explains why Java remains crucial for backend development and explores its advantages over newer languages.', NOW()),
(3000, 'Sibirajen', 1000, 'Spring Boot: A Comprehensive Guide for Beginners', 'Spring Boot simplifies the development of Java applications. This guide covers the basics, from setting up your first Spring Boot project to deploying it to the cloud, making it an essential read for beginners.', NOW()),
(4000, 'Sibirajen', 1000, 'The Importance of Data Structures in Problem Solving', 'Understanding data structures is key to solving complex problems efficiently. This article explains how to approach data structure challenges and improve your algorithmic thinking.', NOW()),
(5000, 'Sibirajen', 1000, 'Best Practices for Writing Clean Code', 'Writing clean code is essential for maintaining a scalable and understandable codebase. This article shares tips on writing clean, readable, and efficient code, following the SOLID principles.', NOW()),
(6000, 'Sibirajen', 1000, 'Understanding Microservices Architecture', 'Microservices is an architectural style that structures an application as a collection of loosely coupled services. In this article, we dive deep into the principles, benefits, and challenges of adopting microservices in modern applications.', NOW()),
(7000, 'Sibirajen', 1000, 'A Guide to Unit Testing in Java', 'Unit testing is an essential practice for ensuring code reliability and correctness. This article covers the best tools and frameworks for unit testing in Java and provides practical examples.', NOW());
