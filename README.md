이 프로젝트는 JPA학습용 예제입니다. 이 예제의 코드는 제가 작성한 부분도 있지만,
대부분 스프링의  JPA 예제 프로젝트에서 가져온 것입니다. 따라서 저에게 저작권은 없으며
모든 저작권은 스프링에 있음을 미리 밝혀둡니다.

다른분이 가져가셔서 활용하시는 것은 자유로이 하실수 있으며,
다만 저작권을 주장하실 수는 없습니다. (원 저작권은 스프링에 있으므로)
도움이 되기를 바랍니다.



-발표 진행순서-

1. ORM 개념발표
2. 간단한 코드 설명
 - Repository의 구현에 대해 설명
    - Spring Data for JPA document: http://docs.spring.io/spring-data/data-jpa/docs/current/reference/html/#jpa.query-methods
3. 흔히 오해하는 부분에 대한 설명
 - OneToMany관계시 자식관계의 데이터를 전부로딩해야한다고 생각하는 경우
    - http://localhost:8080/review/hotel?reviewId=1&hotelId=2
 - 자식 객체에게 부모의  ID만 전달하려 할때 부모객체의 모든 데이터를 불러와햐 한다고 생각하는 경우
    - http://localhost:8080/hotel/findId?hotelId=27
 - JPA 세션 종료 후 객체의 상태를 변경하면 DB에 반영된다고 생각하는 경우
    - 실행: http://localhost:8080/commitTest?hotelName=Conrad%20Treasury%20Place&newName=hahahahahah
    - 결과확인: http://localhost:8080/hotel?hotelName=Conrad%20Treasury%20Place&cityName=Brisbane
