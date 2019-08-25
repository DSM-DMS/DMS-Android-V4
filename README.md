# DMS-Android-V4

## People

* 송진우, 손승용

## Time

* 2019년 8월 26일 ~ 2019년 10월 31일

## Develop Rule

* 기본적으로 애자일에 근거한 Develop Process를 가진다. 

* 작은 Feature를 스프린트를 통해 이루는 방식으로 개발을 한다. 스프린트 후엔 반드시 회고과정을 거친다. 

* 이 과정에서 팀원끼리 서로 신뢰하고 서로 지식을 공유하며 자신이 맡은 업무는 끝까지 책임을 진다. 

* 가장 최우선 되어야 할 것은 유저. 즉, 학생들의 편의성이다. 그 것을 통해 우리의 서비스는 가치를 얻는다. 

* 소통은 우리 안드로이드팀에서만 하지 않고 다른팀과도 소통을 한다. 특히 디자이너 팀과의 소통으로 사용자에게 최고의 UX를 제공할 수 있도록 한다.

## Git Rule

* Git Process는 다음과 같은 Git Work Flow를 최대한 지키며 필요시 realse와 hotfix 부분은 제외 가능 

* commit의 summary은 [Update] 등 무슨 사항인지 태그를 달도록 하고 나머지 메시지는 가독성을 위하여 동사 중심의 한글로 적도록 한다. 

* 또한, commit message의 description은 꼭 적고 코드 변경 사항의 What보다는 Why에 근거한 설명을 적도록 한다. 

## Resource Rule

* 작년과 동일하게 color와 string은 전부 colors.xml, string.xml에서 관리한다. 

* 네이밍은 다음과 같이 작성한다.
  * drawable은 what_description_where 
  * Layout은 what_description
  * ID는 where_description_what, colors는 what

## Module Structure

* Domain: entity, usecase, service, repository, mapper, base

* Data: entity, dto, remote, local, datasource, mapper, repository, database, base 

* Presentation: di, viewmodel, model, mapper, ui, base 

* 세부구조는 좀 더 복잡할 수 있다.

## Language

1. Kotlin

## Tech

1. MVVM

2. Clean Architecture

3. Android JetPack

4. RxJava, RxKotlin, RxAndroid

5. RxBinding

6. Dagger2

7. Arrow

8. Glide, Retrofit2, Okhttp3, Anko, Lottie, etc..

9. Clean Code

10. Functional Reactive Programming

## Test

1. TDD

2. Kluent

3. Mokito

4. JUnit5

## DMS Task

#### 1차 스프린트 - 2주 
* 진우: [ 급식, 잔류, 상벌점, 연장신청 ], 승용: [ 로그인, 회원가입, 외출 신청, 비밀번호 변경 ] 

#### 1차 회고, 1차 코드리뷰 - 1주

#### 2차 스프린트 - 2주 
* 진우: [ 1:1 채팅, 세팅, 공지 사항 ], 승용: [ 기상 음악, 마이페이지 ]

#### 2차 회고, 2차 코드리뷰 - 1주

## PMS Task

#### 3차 스프린트 - 2주
* 진우: [ 주말 외출, 질병 상태, 로그인, 가입, 급식 여부 ], 승용: [ 학교 행사, 잔류 여부, 학생 정보 ]

* 3차 회고, 3차 코드리뷰 - 1주
