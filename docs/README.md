# 구현 기능 목록

## 기능

* [x] 0~9 사이의 랜덤값 생성
* [x] 랜덤값이 4이상이라면 전진


## 입력

* [x] 경주할 자동차 이름 입력
  * 쉼표를 기준으로 분리
  * 자동차 이름 길이는 5이하
* [x] 시도할 횟수 입력

## 출력

* [x] 각 차수별 실행 결과 출력
* [x] 최종 우승자 출력
  * 우승자는 한명 이상


## 예외 사항

* [x] 경주할 자동차가 없는 경우
* [x] 경주할 자동차 이름이 1이상 5이하가 아닌 경우
* [x] 경주할 자동차 이름이 공백인 경우
* [x] 경주할 자동차 이름에 특수 문자가 포함되어 있는 경우
  * 이름은 한글, 숫자, 영어만 가능하다
  * 공백은 이름 사이에만 허용
    * o: "동 글"
    * x: " 동글", "동글 " -> 이 경우에는 공백 제거
* [x] 경주할 자동차 중 중복된 이름이 있는 경우
* [x] 이름 구분자가 연속으로 포함되어 있는 경우
* [x] 공백 제거 후 중복된 이름이 있는 경우
* [x] 시도할 횟수가 0과 양의 정수가 아닌 경우

## 리팩토링 목록

* [x] 1급 컬렉션 사용
* [x] 상수 사용
* [x] 인터페이스 적극 활용(메시지를 던지자)
* [x] Integer 대신 Long 사용 고려
  * 다시 Integer로 변경
* [x] Util 클래스 대신 인터페이스로 랜덤숫자 생성

## 고민해볼 주제

* [x] 마지막에 , 로 끝나는 경우
  * 해당 경우는 예외 처리 하지 않음
  * new String[]{"1", "3", }; 같은 경우도 가능하기 때문
* [x] 각 차수별 실행 결과 출력의 순서
  * 사용자 입력순
  * 사전정렬순
  * 현재 순위 오름차순
    * 무엇이 됐던간 OrderStrategy 구현해주면 된다
* [x] 최종 우승자 출력의 순서
  * 사용자 입력순
  * 사전정렬순
* [x] 이름에 공백이 포함되어 경우
  * 공백 제거
* [x] Model, DTO 각 개념에 대해 짚고 넘어가기