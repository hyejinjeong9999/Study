# Data type

````python
my_list = [1, 2, 3]
my_dict = {"풀": 800, "색연필": 3000}
my_tuple = (1, 2, 3)
number = 10
real_number = 3.141592

print(type(my_list))
#결과 : <class 'list'>
print(type(my_dict))
# 결과 : <class 'dict'>
print(type(my_tuple))
#결과 : <class 'tuple'>
print(type(number))
# 결과 : <class 'int'>
print(type(real_number))
#결과 : <class 'float'>
````

`type( a ) # type( 변수명 )` : 자료형

`isinstance( 42, int ) # isinstance( 값, 자료형 )` : 자료형 검사



# class

* 클래스 : 함수나 변수들을 모아 놓은 집합체
* 인스턴스 : 클래스에 의해 생성된 객체, 인스턴스 각자 자신의 값을 가지고 있ㄷ가

class Car():

​    name = ""

````python
#클래스 생성
class Car():
    name = ""
    
#인스턴스 생성
taxi = Car()
taxi.name = "택시"
````



* 모델링

  * 클래스로 현실의 개념을 표현

* 메소드 = 클래스 내 함수

  * 클래스에 묶여서 클래스의 인스턴스와 관계되는 일을 하는 함수
  * 인자를 받을 때 맨 앞에 무조건 self가 있어야 함

  ````python
  class Car():
      name=""
      def run(self):
          print("{}가 달립니다.".format(self.name))
  
  taxi = Car()
  taxi.name = "택시"
  taxi.run()
  #결과 : 택시가 달립니다
  ````



````python
class Human( ):
    '''인간'''
    def __init__( self, name, weight ):
        '''초기화 함수'''
        self.name = name
        self.weight = weight

    def __str__( self )
        '''문자열화 함수
        return "{} ( 몸무게 {}kg )".format( self.name, self.weight )

person = Human( "사람", 60.5 ) # 초기화 함수 사용
print( person ) # 문자열화 함수 사용
````

````python
class Human():
    
    def __init__(self, name, weight):
        self.name = name
        self.weight = weight
    
    def __str__(self):
        return "{} (몸무게 {}kg)".format(self.name, self.weight)
    
    def eat(self):
        self.weight += 0.1
        print("{}가 먹어서 {}kg이 되었습니다.".format(self.name, self.weight))
    
    def walk(self):
        self.weight -= 0.1
        print("{}가 걸어서 {}kg이 되었습니다.".format(self.name, self.weight))

# 아래에서 person을 이름과 몸무게를 가지는 Human클래스의 인스턴스로 만들어보세요.
person= Human("개똥이",100)
person.walk()
person.walk()
person.eat()
print(person)

#결과
#개똥이가 걸어서 99.9kg이 되었습니다.
#개똥이가 걸어서 99.80000000000001kg이 되었습니다.
#개똥이가 먹어서 99.9kg이 되었습니다.
#개똥이 (몸무게 99.9kg)
````





* `__init__`
  * 인스턴스를 만들 때 실행되는 함수

* `__str__`
  * 인스턴스 자체를 출력 할 때의 형식을 지정해주는 함수