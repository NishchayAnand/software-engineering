A minimal python package consists of 2 elements: a directory and a python file. The name of the directory will be the name of the package. PEP 8 states that packages should have short, all-lowercase names.

> NOTE: The use of underscores in a package name is discouraged, but you can and should use them if it improves readability.

The python file in the package directory must be named `_ _int_ _.py`. This file lets python know that the directory we created is a package.

---
### Steps to Portability

Two main steps to sharing a python package are creating `setup.py` and `requirements.txt`. 

These two pieces provide information on **how to install your package** and **recreate its required environment**. These files list information about what dependencies you've used as well as allowing you to describe your package with additional metadata.

**`requirements.txt`**

A requirements file shows how to recreate the environment needed to properly use your package. This includes a list of python packages and optionally the version requirements for each package. 

If we don't have a reason to specify a version we can just list the package name. If version is important. We can mark a specific version by using a double equals, or mark a minimum version by using greater than or equal. 

> **NOTE:** Since open source packages are constantly evolving, specifying a version can be a big help to your users. 

To leverage our requirements file we can use **`pip install -r requirements.txt`** command. This installs all the packages listed with respect the correct version. 

> **NOTE:** `pip install -r requirements.txt` didn't actually install our package, it just recreated the environment.

**`setup.py`**

`setup.py` is what tells pip how to install our actual package. Additionally, its info will be used by PyPi if you decide to publish.




