# 코드로 배우는 스프링 부트 웹 프로젝트

이 레포지토리는 `코드로 배우는 스프링 부트 웹 프로젝트` 책을 통하여 공부한 내용을 기록을 남기기 위한 레포지토리입니다.

코드는 책을 보며 예제를 따라한 것이며, 혹여 나중에 필요한 코드가 있다면 이 레포지토리를 참고하기 위해 만들었습니다.

사용한 기술은 다음과 같습니다.

- Spring Boot 2.5.x
- Spring Data JPA
    - Querydsl
- MariaDB
- Spring Security

## N:1(다대일) 매핑관계

FK를 사용하는 엔티티가 PK를 가진 엔티티를 참조하는 구조로 설계하면 편하다

객체지향보다는 관계형 데이터베이스 모델링을 위주로 해서 구성하면 좀 더 편하다.

- member 테이블은 pk만 가지고 있고, 별도의 참조가 필요하지 않는다.
- board 테이블은 member의 이메일(pk)을 FK로 참조하는 구조이다.

![test drawio](https://user-images.githubusercontent.com/55525868/151691119-d4a899cd-6956-4d41-a8bd-6bdd9cc84d1e.png)

## 목록, 조회화면

- 목록 화면: 게시글의 번호, 제목, 댓글개수, 작성자의 이름/이메일
- 조회 화면: 게시글의 번호, 제목, 내용, 댓글개수, 작성자 이름/이메일

## JPA 성능 주의

- 전략에는 `Eager` 전략과 `Lazy` 전략이 있다.
- Lazy 전략을 사용해야 성능을 개선시킬 수 있는데 이 때 `@ToString`에 꼭 `exclude` 속성을 명시해주어야 한다.
  - P248 참고
- 제일 보편적인 방법은 **지연로딩을 기본으로 사용하고, 상황에 맞게 필요한 방법을 찾는다** 입니다.
- 