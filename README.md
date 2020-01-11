## Stream Class
Colleciton의 요소를 하나씩 참조해서 람다식으로 처리할 수 있는 클래스

#### java 7 이전 코드
##### 예시 1
```java
List<String> data = Arrays.asList("아메리카노","카페라떼","콜드브루","바닐라 라떼");
iterator<String> iterator = data.iterator();
while(iterator.hasNext()){
   System.out.println(iterator.next());
}
```
##### 예시 2
```java
List<String> data = Arrays.asList("아메리카노","카페라떼","콜드브루","바닐라 라떼");
for(String name: data){
    System.out.println(name);
}
```
#### java 8 이후 코드
```java
List<String> data = Arrays.asList("아메리카노","카페라떼","콜드브루","바닐라 라떼");
data.stream().forEach(System.out::println);
```


#### Stream class의 장점
- Exteranl iterator remove
> 직접 코드로 collection 요소를 반복해서 가져오는 방법
- Internal iterator
> 처리 요소에만 집중, 멀티코어 CPU를 활용하여 요소들을 분배시켜 병렬처리 가능
- Parallel Processing
> 한가지 작업을 여러 개의 서브 작업으로 나누고, 나누어진 서브 작업을 분리된 스레드에서 병렬적으로 처리한 후 그 결과들을 모두 합쳐서 처리하는 방식
> 자바는 기본적으로 <b>ForkJoinPool</b>를 이용해서 병렬처리를 함.

#### Stream class이 종류
> java.util.stream 패키지 하위에 인터페이스 타입으로 제공,
모든 스트림에서 공통으로 사용하는 메소드들이 정의된 BaseStream 인터페이스를 
상속받아 각 데이터 타입에 맞게 인터페이스들이 선언되어있음

- BaseStream
    - Stream
    - IntStream
    - LongStream
    - DoubleStream

##### 각 자료형별 Stream 활용 예
###### 1. Collection
```java
List<Customer> customerList = Arrays.toList(
    "홍길동1", "홍길동2", "홍길동3", "홍길동4", "홍길동5"
);
Stream<Customer> stream = customerList.stream();
stream.forEach(customer->{
  System.out.println(customer.getName());
});
```

###### 2. Array
```java
String[] customerArray = {"홍길동1", "홍길동2", "홍길동3", "홍길동4", "홍길동5"};
Stream<Customer> stream = Arrays.stream(customerArray);
stream.forEach(name->{
  System.out.println(name);
});
```

###### 3. Integer
```java
int sum = 0;
// IntStream.rangeClosed(inclusive, exclusive)
IntStream stream = IntStream.rangeClosed(1,100);
stream.forEach(value -> sum += value);
System.out.println("Sum from 1 to 100 is => " + sum);
```
