# linux4

* root암호복구 / 커널은 책만읽기 
* 커널

| 소프트웨어 | 리눅스                   |
| ---------- | ------------------------ |
| 커널       | 제어프로그램 내장        |
| 하드웨어   | cpu, processro, harddisk |



## 네트워크

#### 명령어

* ifdown/up
  * 네트워크 중단 / 시작
* systemctl start network
  * 부팅을 자동으로 함
* systemctl
  * 시스템제어 명령어
* nslookup
  * 외부의 도메인을 입력했을 때 gateway가 연결해주는 도메인까지 도달할때의 경로를 찾아줌
* ping ip
  * 내 컴퓨터와 상대방 컴퓨터가 통신이 가능한지



#### 설정파일

* `/etc/sysconfig/network-scripts/ifcfg-(eno16777736)`
  * (는 네트워크 이름)
  * 네트워크이름, 맥어드레스, ip, gw, dns를 조회 및 수정
  * 수정시 `systemctl start network`로 재부팅해야함
* `/etc/sysconfig/host/name`
  * 네트워크상 내 컴퓨터 이름 설정(=localhost)
* `/etc/resolv.conf`
  * dns ip수정 
  * 함부로 바꾸면 네트워크가 불가능해짐



## 리눅스와 java

* `/user/local/tomcat9/bin/startup.sh`
  * 시작 _ 종료 명령어

* `/user/local/tomcat9/conf`
  * 설정파일,xml

#### 방법

1. `/user/local/tomcat9/lib/*.jar + ojdbc6.jar`

2. `/user/local/tomcat9/webapps/스프링mvc프로젝트폴더`



#### 실습

톰캣시작

````
[root@localhost ~]# /usr/local/tomcat/bin/startup.sh 

Using CATALINA_BASE:   /usr/local/tomcat
Using CATALINA_HOME:   /usr/local/tomcat
Using CATALINA_TMPDIR: /usr/local/tomcat/temp
Using JRE_HOME:        /usr/local/jdk1.8
Using CLASSPATH:       /usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar
Tomcat started.
````

* jdk 설치 안됐거나 path설정이 안되어있으면 오류가난다

리눅스 - localhost-접속

파이어폭스 접속

````
[root@localhost ~]# /root/다운로드/firefox/firefox
````

톰캣 실행되는지 확인

![image-20200221094802015](C:\Users\student\Desktop\Study\Study\md_img\image-20200221094802015.png)



호스트OS에서도 실행

* 접속이 불가능
  * 방화벽의 문제로 접근하지 못함
* 방화벽 
  * 9090포트로 변경
  * 9090포트로 요청하는 컴퓨터에게만 방화벽 해제

톰캣포트 변경

`/user/local/tomcat9/conf/server.xml`에서 포트번호 변경

````
[root@localhost ~]# gedit /usr/local/tomcat/conf/server.xml 

````

69번 line 8080 -> 9090으로 변경

후에 오라클과의 충돌을 막기 위해

````
<Connector port="9090" protocol="HTTP/1.1"
               connectionTimeout="20000"
               redirectPort="8443" />
````

톰캣 종료후 재시작

````
[root@localhost ~]# /usr/local/tomcat/bin/shutdown.sh 

Using CATALINA_BASE:   /usr/local/tomcat
Using CATALINA_HOME:   /usr/local/tomcat
Using CATALINA_TMPDIR: /usr/local/tomcat/temp
Using JRE_HOME:        /usr/local/jdk1.8
Using CLASSPATH:       /usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar

[root@localhost ~]# /usr/local/tomcat/bin/startup.sh 
Using CATALINA_BASE:   /usr/local/tomcat
Using CATALINA_HOME:   /usr/local/tomcat
Using CATALINA_TMPDIR: /usr/local/tomcat/temp
Using JRE_HOME:        /usr/local/jdk1.8
Using CLASSPATH:       /usr/local/tomcat/bin/bootstrap.jar:/usr/local/tomcat/bin/tomcat-juli.jar
Tomcat started.

````



9090포트 요청 컴퓨터 방화벽 해제

````
system
````

방화벽 설정

````
[root@localhost ~]# firewall-config 
````

* 설정 : 영구적
* public  - 포트 - 추가 - 포트범위 : 9090 ,(tcp) -
* 옵션 - firewalld 다시 불러오기 (재시작)

윈도우상 접속 확인

![image-20200221101418407](C:\Users\student\Desktop\Study\Study\md_img\image-20200221101418407.png)

윈도우에 있던 웹프로젝트 옮겨보기

1. dynamic web project

   * webcontent 안에 jsp파일이 있으면 됐음

   * 리눅스는 다름 (이클립스보고 바꿔달라고 하기)

   * tomcat9 구조 맞춰서 압축시켜줘

   * Export - Export -Web - WAR file 

     ![image-20200221102454035](C:\Users\student\Desktop\Study\Study\md_img\image-20200221102454035.png)

war파일 - vm - 다운로드에 넣기

tomcat에 이동

````
[root@localhost ~]# pwd
/root

[root@localhost ~]# mv 다운로드/vm.war /usr/local/tomcat/webapps

[root@localhost ~]# ls /usr/local/tomcat/webapps
ROOT  docs  examples  host-manager  manager  vm  vm.war


````

* vm이 압축파일과war 파일이 생김

확인

![image-20200221103133976](C:\Users\student\Desktop\Study\Study\md_img\image-20200221103133976.png)



1. Spring mvc project

war파일 옮기기

.jsp가 컨텍스트명이 아니라 파일명 그대로가 이름임

spring

![image-20200221105126750](C:\Users\student\Desktop\Study\Study\md_img\image-20200221105126750.png)

디플로이



## 오라클 설치 571p

* [오라클](www.oracle.com)

Database 11g Enterprise/Standard Editions 버전 다운로드

Oracle Database 11g Release 2 Express Edition for Linux x86 and Windows

````

[root@localhost ~]# cd 다운로드/
[root@localhost 다운로드]# unzip oracle*
Archive:  oracle-xe-11.2.0-1.0.x86_64.rpm.zip
   creating: Disk1/
   creating: Disk1/upgrade/
  inflating: Disk1/upgrade/gen_inst.sql  
   creating: Disk1/response/
  inflating: Disk1/response/xe.rsp   
  inflating: Disk1/oracle-xe-11.2.0-1.0.x86_64.rpm  
  
[root@localhost 다운로드]# cd Disk1/

[root@localhost Disk1]# rpm -qip oracle-xe-11.2.0-1.0.x86_64.rpm
Name        : oracle-xe
Version     : 11.2.0
Release     : 1.0
Architecture: x86_64
Install Date: (not installed)
Group       : Applications/OracleXE
Size        : 591492962
License     : Oracle Corporation
Signature   : (none)
Source RPM  : oracle-xe-11.2.0-1.0.src.rpm
Build Date  : 
Build Host  : dadvfg0711.us.oracle.com
Relocations : (not relocatable)
Packager    : Oracle <www.oracle.com>
URL         : http://www.oracle.com
Summary     : Oracle Database 11g Release 2 Express Edition
Description :
Oracle Database 11g Release 2 Express Edition

````

swap : 임시메모리공간 많이 잡으면 파일 저장할 공간이 얼마 안남음

보통 2g를 권고하는데 oracle은 swap공간을 사용하기때문에 부족함

임시적으로 swap 공간을 늘린다

````
[root@localhost Disk1]# free -m
             total       used       free     shared    buffers     cached
Mem:          1987       1910         77         39          0        392
-/+ buffers/cache:       1518        469
Swap:         1999         70       1929

````

````
[root@localhost Disk1]# swapon -s
Filename				Type		Size	Used	Priority
/dev/sda1                              	partition	2047996	72224	-1

````

* * 

````
[root@localhost Disk1]# cd /root/다운로드/Disk1/
[root@localhost Disk1]# ls -l
합계 309884
-rw-rw-r-- 1 root root 317320273  8월 29  2011 oracle-xe-11.2.0-1.0.x86_64.rpm
drwxr-xr-x 2 root root        19  8월 29  2011 response
drwxrwxr-x 2 root root        25  8월 29  2011 upgrade
[root@localhost Disk1]# yum -y localinstall oracle*
Loaded plugins: fastestmirror, langpacks
Examining oracle-xe-11.2.0-1.0.x86_64.rpm: oracle-xe-11.2.0-1.0.x86_64
Marking oracle-xe-11.2.0-1.0.x86_64.rpm to be installed
Resolving Dependencies
--> Running transaction check
---> Package oracle-xe.x86_64 0:11.2.0-1.0 will be installed
--> Finished Dependency Resolution

Dependencies Resolved

============================================================================
 Package      Arch      Version       Repository                       Size
============================================================================
Installing:
 oracle-xe    x86_64    11.2.0-1.0    /oracle-xe-11.2.0-1.0.x86_64    564 M

Transaction Summary
============================================================================
Install  1 Package

Total size: 564 M
Installed size: 564 M
Downloading packages:
Running transaction check
Running transaction test
Transaction test succeeded
Running transaction
  Installing : oracle-xe-11.2.0-1.0.x86_64                              1/1 
Executing post-install steps...
You must run '/etc/init.d/oracle-xe configure' as the root user to configure the database.

  Verifying  : oracle-xe-11.2.0-1.0.x86_64                              1/1 

Installed:
  oracle-xe.x86_64 0:11.2.0-1.0                                             

Complete!

````

````
[root@localhost Disk1]# rpm -qa | grep oracle
oracle-xe-11.2.0-1.0.x86_64

````

oracle 이름이 잇는것중에 찾아서 띄우기 -qa : 설치파일 정보 확인

#### 오라클 설정

````
[root@localhost xe]# . /u01/app/oracle/product/11.2.0/xe/bin/oracle_env.sh 
[root@localhost xe]# gedit /etc/bashrc 
에서
`. /u01/app/oracle/product/11.2.0/xe/bin/oracle_env.sh`
입력
````



방화벽 설정

1521 / 8080 추가

* 연결

````
[root@localhost xe]# sqlplus

SQL*Plus: Release 11.2.0.2.0 Production on 금 2월 21 13:54:54 2020

Copyright (c) 1982, 2011, Oracle.  All rights reserved.

Enter user-name: system 
Enter password: 

Connected to:
Oracle Database 11g Express Edition Release 11.2.0.2.0 - 64bit Production

````

* sql 연결



````
SQL> select * from tab;

TNAME			       TABTYPE	CLUSTERID
------------------------------ ------- ----------
COUNTRIES		       TABLE
DEPARTMENTS		       TABLE
EMPLOYEES		       TABLE
EMP_DETAILS_VIEW	       VIEW
JOBS			       TABLE
JOB_HISTORY		       TABLE
LOCATIONS		       TABLE
REGIONS 		       TABLE

8 rows selected.

````

