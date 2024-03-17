class Car:
    # public attributes
    brand = "Toyota" 
    model = None
    __cost = None

my_car = Car()
print(my_car.brand)
# print(my_car.__cost) --> will throw error that attribute does not exists
# print(my_car._Car__cost) --> workaround to access private attributes, but highly discouraged as it breaks data hiding.

#--------------------------------------------------------------------------------------
class Scooter:
    # constructor
    def __init__(self, brand, model):
        # public attributes
        self.brand = brand
        self.model = model
        # private attributes
        self.__cost = None

    def full_name(self):
       return f"{self.brand} {self.model}"

my_scooter = Scooter("Bajaj", 'X')
print(my_scooter.brand)
print(my_scooter.full_name())
# print(my_scooter.__cost) --> will throw error that attribite does not exist

#----------------------------------------------------------------------------------

# superclass
class Vehicle:
  def __init__(self):
    # protected attributes
    self._cost = None

# subclass
class Truck(Vehicle):
  def get_cost(self):
    print(self._cost)  # Access from subclass is allowed

truck = Truck()
print(truck.get_cost())
# print(truck._cost)  # works, but not recommended