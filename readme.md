### 필요기능
    1. todo리스트 목록에 아이템 추가
    2. todo리스트 목록 중 특정 아이템을 조회
    3. todo리스트 전체 목록을 조회
    4. todo리스트 목록 중 특정 아이템을 수정
    5. todo리스트 목록 중 특정 아이템을 삭제
    6. todo리스트 전체 목록 삭제

### 이슈
- 현재 complated boolean 타입이 이상하다.
    1. null 체크 불가능으로 문제가 있다
       - [컨트롤러](/src/main/java/org/example/controller/TodoController.java)