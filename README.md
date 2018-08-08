## Bloomfilter-vavr-mybatis-with-springboot
	
####Bloom Filter

Bloom filter is a probablistic data structure, which may produce false positives and never produces false negatives. 
Bloom filter uses less space to store more values with n number of hash functions, it trades accuracy for space.
It is normally used for entry check to determine whether the given value/info possibily in the database.
This project uses google's guava library collections.

For more details
 
https://www.baeldung.com/guava-bloom-filter

#### Vavr

Vavr is functional library for java, which provides null check, immutable object collections, tuples and more
This project demo's the use of Option class from vavr for null check 

For more details

http://www.baeldung.com/vavr-tutorial

#### Mybatis

It's alternative to JDBC and hibernate, open source, light weight. Unlike hibernate/jpa it doesn't generate it's own query, instead uses the query defined by user in mapper xml files

For more details

https://www.tutorialspoint.com/mybatis/index.htm

### Find operations with bloom filter check
-------------------------------------------
1. Find game by id

	> http://localhost:8080/Games/findByID/1


2. Find game by name

	> http://localhost:8080/Games/findByName/skyrim

 

	