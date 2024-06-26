﻿### Git convention
<details>
<summary>Git-flow</summary>

| Name     | Description                            |
|:---------|:---------------------------------------|
| master   | 제품으로 출시될 수 있는 브랜치          |
| develop  | 다음 출시 버전을 개발하는 브랜치       |
| feature  | 기능을 개발하는 브랜치                 |
| release  | 이번 출시 버전을 준비하는 브랜치       |
| hotfix   | 출시 버전에서 발생한 버그를 수정하는 브랜치 |

</details>

<details>
<summary>Git commit message</summary>

##### Structure
```
type: [#issueNumber] Subject
(blank line)
body // 본문
```
##### Type
| Tag Name | Description |
|:---------|:------------|
| Feat     | 새로운 기능을 추가 |
| Fix      | 버그 수정 |
| Style    | 코드 포맷 변경, 세미 콜론 누락, 코드 수정이 없는 경우 |
| Refactor | 프로덕션 코드 리팩토링 |
| Comment  | 필요한 주석 추가 및 변경 |
| Docs     | 문서 수정 |
| Test     | 테스트 코드, 리팩토링 테스트 코드 추가, Production Code 변경 없음 |
| Chore    | 빌드 업무 수정, 패키지 매니저 수정, 패키지 관리자 구성 등 업데이트, Production Code 변경 없음 |
| Rename   | 파일 혹은 폴더명을 수정하거나 옮기는 작업만인 경우 |
| Remove   | 파일을 삭제하는 작업만 수행한 경우 |

##### Subject
- 50글자 이내로 작성한다.
- 마침표 및 특수 기호를 사용하지 않는다.
- 현재 시제로 작성한다.
- 간결한 개조식 구문 사용한다.
- 영문으로 작성 시 동사원형, 명령형으로 작성한다. (한글 작성 가능)

##### Body
- 72글자 이내로 작성한다.
- 코드 변경 시 ‘어떻게’ 보다 ‘무엇을’, ‘왜’ 변경했는지 작성한다.

</details>

