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
# print(my_scooter.brand)
# print(my_scooter.full_name())
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
# print(truck.get_cost())
# print(truck._cost)  # works, but not recommended

#-------------------------------------------------------------------------------------
class Car:
    # class variables
    totalCars = 0

    def __init__(self, brand, model):
       self.brand = brand
       self.model = model
       Car.totalCars += 1

Car("Toyota", "Innova")
Car("Maruti", "Invicto")
print(Car.totalCars)