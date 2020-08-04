# git 추가정보

# 삭제 / 폴더명 수정

`git add -u`

`git commit -a`



# 잔디밭 안생길 때

1. Github에서 `settings - Emails`에 있는 Primary 이메일을 확인 
2. .gitconfig 파일에 해당 이메일과 github 이름을 적어주기

	````bash
	$ git config --global user.name "유저명"
	$ git config --global user.email 유저이메일
	````

3. 확인

   ````
   $ git config user.name
   유저명
   $ git config user.email
   유저이메일
   ````

   