# Inheritance

## 상속

* 자식 클래스가 부모 클래스의 내용을 가져다 씀
* 부모클래스
  * 상속하는 클래스
* 자식 클래스
  * 상속 받는 클래스

````python
#부모클래스
class Animal( ):
    def walk( self ):
        print( "걷는다" )

    def eat( self ):
        print( "먹는다" )
#자식 클래스
class Human( Animal ):
    def wave( self ):
        print( "손을 흔든다" )

#자식클래스
class Dog( Animal ):
    def wag( self ):
        print( "꼬리를 흔든다" )
````



````python
class Car():    
    def run(self):
        print("차가 달립니다.")


class Truck(Car):
    def load(self):
        print("짐을 실었습니다.")
````



## 오버라이드

* 같은 이름을 가진 메소드를 덮어 쓴다

````python
class Animal( ):
    def greet( self ):
        print( "인사한다" )

class Human( Animal ):
    def greet( self ):
        print( "손을 흔든다" )

class Dog( Animal ):
    def greet( self ):
        print( "꼬리를 흔든다" )
````

````python
class Car():
    def run(self):
        print("차가 달립니다.")


class Truck(Car):
    
    def load(self):
        print("짐을 실었습니다.")
    #오버라이드
    def run(self):
        print("트럭이 달립니다.")
    
    
truck = Truck()
truck.run()
#트럭이 달립니다
````





## super

* 자식클래스에서부모클래스의 내용을 사용할 때
* super().부모클래스내용

````python
class Animal( ):
    def __init__( self, name ):
        self.name = name

class Human( Animal ):
    def __init__( self, name, hand ):
        super().__init__( name ) # 부모클래스의 __init__ 메소드 호출
        self.hand = hand

person = Human( "사람", "오른손" )
````

````python
class Car():
    
    def __init__(self, name):
        self.name = name

    def run(self):
        print("차가 달립니다.")


class Truck(Car):
    # __init__ 메소드를 오버라이드 
    def __init__(self,name,capacity) :
        super().__init__(name)
        self.capacity = capacity
        
    def load(self):
        print("짐을 실었습니다.")
        
````