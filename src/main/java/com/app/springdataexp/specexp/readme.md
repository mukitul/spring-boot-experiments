## Spring Data JPA-Specification
Uses Hibernate's criteria api for making dynamic query.

- [Specification Example](./src/main/java/com/app/springdataexp/specexp)
- JPA Metamodel: When we write a criteria query, we need to reference entity classes and their attributes. Now, one of
  the ways of doing this is to provide the attributes' names as strings.
  But, this has several downsides. For one, we have to look up the names of entity attributes. And, in case a column name
  is changed later in the project lifecycle, we have to refactor each query where the name is being used.

The JPA Metamodel was introduced by the community to avoid these drawbacks and provide static access to the metadata of
the managed entity classes.

- Set up JPA Metamodel:

i) add dependency
```
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-jpamodelgen</artifactId>
    <version>5.3.7.Final</version>
</dependency>
```
ii) configuration section for annotation processing
```
ctrl+alt+s > Build,Execution,Deployment > Compilers > Annotation Processors

Enable annotation processing and Select obtain from project classpath. 
Add the annotation processor name "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor"
```
Here is reference image of this setup:
![jpa metamodel setup in idea](/public/jpa-metamodel-setup.png "WELCOME TO JUNGLE")
