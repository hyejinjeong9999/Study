## Git status& undoing 

### 1. commit

```bash
student@M160211 MINGW64 ~/Desktop/git_pluse (master)
$ touch a.txt

#working Directory는 있으나 Staging area에는 없다

$ git commit

# commit할 것이 없지만 -> staging area가 비어있음
# untracted file이 있다 ->git commit 이력에 담기지 않은 파일은 있다
On branch master
Initial commit
Untracked files:
        a.txt
nothing added to commit but untracked files present

#a.txt가 없을 때
# WD X, staging area X
$ git commit
#어떠한 변경사항도 없음
On branch master
Initial commit
nothing to commit

```



### status

1. 새로 파일 생성 한 경우

    ```bash
    $ touch a.txt

    $ git status
    On branch master
    No commits yet
    #commit 이력에 담긴 적 없는 파일을
    Untracked files:
      (use "git add <file>..." to include in what will be committed)
            a.txt
    #커밋 할 목록(Staging area)에 추가하려면 git add <file>

    nothing added to commit but untracked files present (use "git add" to track)
    ```

2. add 한 이후

   ```bash
   $ git add a.txt
   $ git status
   
   On branch master
   No commits yet
   #커밋이 될 변경사항들(changes)
   Changes to be committed:
     (use "git rm --cached <file>..." to unstage)
           new file:   a.txt
   
   ```



### commit 메시지 작성하기

> 부제 : vim 활용 기초

```bash
$git commit

# Please enter the commit message for your changes. Lines starting
# with '#' will be ignored, and an empty message aborts the commit.
#
# On branch master
#
# Initial commit
#
# Changes to be committed:
#       new file:   a.txt
#

```



* 편집(입력모드) : i ->끼워넣기로 변함
  * 문서 편집 가능
* 명령모드 : esc
  * dd : 해당 라인 삭제
  * wq : (콜론 후)저장 및 종료
  * q! : 강제종료
    * q : quit
    * ! : 강제

```bash
$ git commit -m 'commit message'
```



* 커밋 메시지는 항상 해당 작업 이력을 나타낼 수 있도록 작성한다
* 일관적인 포맷으로 작성하려고 노력한다



### log

>  커밋은 해시 값(hash value)에 의해서 구분된다
>
> SHA-1 해서 알고리즘을 사용하여 표현한다

```bash
$ git log --oneline
77b1a12 (HEAD -> master) * a.txt 내용 추가 * blahblah

$ git log
commit 77b1a1267c84270db4f6a303748691c505aadaeb (HEAD -> master)
Author: hyejinjeong9999 <hyejinj810@gmail.com>
Date:   Wed Dec 18 09:41:31 2019 +0900

    * a.txt 내용 추가
    * blahblah

```



### commit undoing

1. 커밋 메시지 수정 (직전 commit)

    ```bash
    $git commit --amend
    ```

    커밋 메시지 수정하는 경우 해시 값이 변경되므로, 다른 이력으로 관리가 된다.

    **따라서 공개된 저장소 (원격 저장소)에 이미 push된 경우 절대 수정해서는 안된다.**



2. 특정 파일 추가하기

   * c. txt 파일을 같이 커밋을 하려고 했는데, add를 하지 않고 커밋 해버렸다
   * 직전 commit상태로 되돌아가는것 시점 자체를 과거로 가는것 

   ```bash
   $git add c.txt
   $git commit --amend
   ```



## Staging area

### 1. 커밋 이력이 있는 파일 수정 하는 경우

```bash
$ git status
On branch master
#변경 사항인데 (WD는 변했는데) Staging area가 아닌 것
Changes not staged for commit:
#git add로 staging area로 보낼 수 있다
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
        modified:   a.txt

```



```bash
$ git status
On branch master
Changes not staged for commit:
  (use "git add <file>..." to update what will be committed)
  (use "git restore <file>..." to discard changes in working directory)
  #unstage 하기 위해서 (Staging area에서 제외하기 위해서)
        modified:   a.txt

```



### add 취소하기

```bash
$git restore --staged <file>
```

* 구버전의 git에서는 아래의 명령어를 사용해야 한다

  ```bash
  $git reset HEAD <file>
  ```

  

### WD 변화 삭제하기

> git에서는 모든 commit시점으로 되돌릴 수 는 없다
>
> 다만 WD 삭제하는 것은 되돌릴 수 없다

* commit하는 시점 : 개발을 완료한 상태

```bash
$ git restore <file>
```

* 구버전 git에서는 아래의 명령어를 사용한다

  ```bash
  $ git checkout -- <file>
  ```

  

# Stash

> 변경사항을 임시로 저장 해놓는 공간
>
> 마지막 커밋 시점으로 되돌려준다.

```bash
1. feature branch에서 a.txt 변경 후 커밋
2. master branch에서 a.txt 수정
(add나 commit 없이)
3. merge

$ git merge feature
error: Your local changes to the following files would be overwritten by merge:
        a.txt
Please commit your changes or stash them before you merge.
Aborting
Updating aa5124a..aecb5ac
```

### 명령어

stash 저장

```bash
$ git stash
Saved working directory and index state WIP on master: aa5124a Edit a.txt
```

stash 목록

```bash
$ git statsh list
stash@{0}: WIP on master: aa5124a Edit a.txt
```

stash 불러오기

```bash
$ git stash pop # 불러오기 + 목록에서 삭제
# $ git stash apply # 불러오기
# $ git stash drop # 목록에서 삭제
```

### 해결

```bash
$ git stash # 임시 공간 저장
$ git merge feature # 병합
$ git stash pop # 임시 공간에서 불러오기
# 충돌 발생, 해결 후 작업 이어가기..!
<<<<<<< Updated upstream
수정수정
=======
마스터마스터
>>>>>>> Stashed changes
```





## Reset vs Revert

###  RESET

> 공개된 저장소(원격저장소)에 push된 이력은 절대 reset 하지 않는다

```bash
$git reset {해시코드}
```

* 기본 {--mixed} : 이후 변경 사항을 WD에 유지시켜줌

* --hard : 이후 변경 사항이 모두 삭제 됨 주의

* --soft : 지금 작업하고 있는 내용(WD) 및 변경사항을 WD에 유지시켜줌



### REVERT

> 해당 커밋으로 되돌렸다는 이력 (revert commit)을 남긴다

``` bash
$git revert {해시코드}
```

* vim -> 커밋메시지 작성
* 직전 시점으로 되돌렸다는 사실 자체를 이력을 남김

