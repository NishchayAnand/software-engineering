'''
class Subclass(BaseClass):
  # Subclass definition
  # Inherits attributes and methods from BaseClass
'''

# superclass
class Animal:
  
  def __init__(self, name):
    self.name = name

  def make_sound(self):
    print("Generic animal sound")

# subclass
class Dog(Animal):  # Dog inherits from Animal
  def __init__(self, name, breed):
    super().__init__(name)  # Call the base class constructor
    self.breed = breed

  def make_sound(self):  # Method overriding
    print("Woof!")

# Create objects
animal = Animal("Generic")
dog = Dog("Fido", "Labrador")

animal.make_sound()  # Output: Generic animal sound
dog.make_sound()  # Output: Woof!
