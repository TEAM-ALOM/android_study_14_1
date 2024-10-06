# android_study_14_1
아롬 안드로이드 14기 스터디 1번

# ToDo
|내용|완료 여부|
|---|:---:|
|MVVM 학습하기|✅|
|ㄴMVVM 코드 구현|✅|
|StateFlow 학습하기|✅|
|ㄴStateFlow 코드 구현|✅|
|SharedPreferences 이용한 저장 기능 구현|✅|
|Repository 학습하기||


# 과제 설명
### 간단하게 메모하고 저장, 불러오는 앱을 만들어봅시다.

단) mvvm + stateflow를 이용해서!

<img src = "https://github.com/user-attachments/assets/94e30e19-f78d-49a4-9cd4-d5dd073ae5bb" width = "40%" height = "40%">  


<br>
<br>





오랜만에 안드로이드 개발하시는 분들도 계실테니 쉬운것 부터

정말 단순하게 하나의 activity에 edittext와 버튼 하나 넣어주시면 됩니다.

버튼을 누르면 edittext에 있는 텍스트를 sharedpreference에 저장합니다.

앱을 종료 후 다시 실행하면 sharedpreference에서 불러옵니다.

뷰는 자유롭게 구성하셔도 상관 없습니다.

방학 스터디를 진행 안하신분들은 mvvm이 뭔지 어려우실수도 있는데요

<img src = "https://github.com/user-attachments/assets/b61038e6-db7e-4930-a7f0-961455ddf480" width = "70%" height = "70%"> 

간단하게 설명하면 우리는 그동안 view(activity&fragment)에서 모든 로직을 담당했다면, 그 역할을 나눠서 의존성을 분리하는겁니다. 

분리를 해서 코드를 구조화 하고, 유지보수하기 쉽게 해줍니다.

테스트코드도 작성할 수 있습니다.

처음에는 왜 나누는건지 이해가 안되는게 당연합니다(저도 그랬어요)

하다보면 알게 될테니 차근차근 해봅시다.

기존에 view에서 수행하던 어떤 역할을 viewmodel에서 처리해야할지 잘 고민해봐요

관련 링크
[https://velog.io/@mi-fasol/Kotlin-MVVM](https://velog.io/@mi-fasol/Kotlin-MVVM)

[https://bj-turtle.tistory.com/106?category=1082099](https://bj-turtle.tistory.com/106?category=1082099)

[https://velog.io/@unisimpson/androidkotlin-MVVM패턴](https://velog.io/@unisimpson/androidkotlin-MVVM%ED%8C%A8%ED%84%B4)

조건

- viewbinding을 사용합니다.
- mvvm + stateflow를 사용합니다.
- databinding은 사용하지 않습니다.

여름방학 스터디 진행해서 난 이게 너무 쉽다! 를 위한 추가 도전과제

- Repository 패턴을 이용해봅시다.
- 코루틴을 이용해서 비동기적으로 저장된 데이터를 읽고 써봅시다.

- ~~junit+mockk 기반의 unit 테스트 코드를 작성해요. (이거 하면 칭찬해드림)~~

---

### 과제 진행 방법

해당 레포지토리를 본인 계정으로 포크해가세요.

과제가 완료 되면 해당 레포지토리에 pull requests를 열어주세요. 

pull requests에 해당 코드에 대한 간단한 설명을 적어주세요.

코드에 대한 의문점이 있다면 같이 남겨주세요

pull requests에 앱의 스크린샷도 같이 남겨주세요.

---

### 커밋 룰

| 태그 이름 | 설명 |
| --- | --- |
| feat: | 새로운 기능을 추가할 경우 |
| fix: | 버그를 고친경우 |
| design: | xml 등 사용자 UI 디자인 변경 |
| style: | 코드 포맷 변경, 린트 수정, 코드 수정이 없는 경우 |
| comment: | 필요한 주석 추가 및 변경 |
| docs: | 문서를 수정한 경우 |
| test: | 테스트 추가, 테스트 리팩토링(프로덕션 코드 변경 X) |
| chore: | 빌드 태스트 업데이트, 패키지 매니저를 설정하는 경우(프로덕션 코드 변경 X) |
| rename: | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우 |
| remove: | 파일을 삭제하는 작업만 수행한 경우 |
| setting: | Gradle, Manifest 등 파일에 세팅 추가 |

커밋할때는 태그를 꼭 붙여주세요.

예시)

```kotlin
- feat(MainActivity, MainViewModel): EditText를 SharedPreference에 저장하는 로직 추가

- comment(MainViewModel): SharedPreference 로직 주석 추가
```

커밋은 최대한 자주 해주세요.

---

깃 사용이 익숙하지 않을 수도 있고, mvvm이 이해가 안될수도 있습니다.

괜찮으니까 저에게 언제든 질문해주세요.

저 지피티 코드 진짜 잘 찾아내니까 지피티 사용은 지양해주세요.

제가 뭐라고 하지 않아도 본인 스스로의 성장에 도움이 되지 않습니다. 개념 질문정돈 괜찮습니다.
