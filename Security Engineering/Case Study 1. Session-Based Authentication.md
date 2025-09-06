
Every user sign in creates a session on the server that is associated with the user record in the database. These session include details such as creation timestamp, expiration timestamp and the current status.

The session ID is set in a cookie and sent back to the client so that the server can validate the user making any future requests from that client. 

**Database Schema**

- **users**: When a user sign up, the application needs to at least store a user ID, username, and password so they can return in the future.

- **sessions**: Allows application to look up a session by ID and determine the user it's associated with.

The backend should hash the user password to make sure they are not stored in plain text. It's good practice to implement data validation at server side to make sure bad data is committed to the database.

Separate your public routes with from those that require a user to be signed in. <span style="color:green;font-weight:bold;background:beige;">In an application with dedicated backends and frontends, you'd typically separate the views in the frontend to prevent unauthorized users from accessing those views.</span>

```
1. Define routes (views) that don't required authentication

- publicPaths = ["/signin", "signup", "/"] 
  
2. Define Filter | Middleware that will intercept all requests
   
- function interceptor(request):
  
	- sessionId = request.cookies.get("sessionId");
	- pathname = request.url
	  
	Step 1: Check if pathname is a publicly accessible path
	- if publicPaths contains pathname:
		  - redirect to home page, i.e., "/";
		    
	Step 2: Check if we have a valid session
	- if sessionId is not None:
		  - redirect to pathname;
	- else:
		  - redirect to signin, i.e., "/signin";
```

--- 
### Create Sign-Up Route

**Frontend Logic**

The client-side sign-up or login page the user will interact with.

```

- [serverErrors, setServerErrors] = useState(string[]);
- [clientErrors, setClientErrors] = useState(string[]);

function HandleSubmit(formData):

	// Step 1: Validate the form data
	- if validation fails: setClientErrors(errors);
	  
	// Step 2: Send sign up request to backend
	- serverResult = backend.signUp(formData);
	  
	// Step3: Valudate serverResult for any errors
	- if serverResult contains error: setServerErrors(errors);
	  
```

**Backend Logic**

To interact with the database to create new users and create sessions.

```
function signUp(email, password):

	// Step 1: Perform server-side validation
	- if validation fails: throw error;
	
	// Step 2: Check if user already exists
	- existingUser = db.users.findByEmail(email);	
	- if existingUser is not None:
		- throw error: "user with this email already exists";
	
	// Step 3: Hash password and create user
	- passwordHash = bcrypt.hash(password, 10);
	- user = db.users.create({email, password});
	
	// Step 4: Create Session
	- createSessionAndCookie(user.id);
	  
	// Step 5: Redirect user to protected route
	- redirect("/protectedRoute");
	
```

```
function createSessionAndCookie(userId):

	- sessionDurationDays = 7;
	- expiresAt = date.now() + sessionDurationDays;
	  
	- session = db.session.create({userId, expiresAt});
	- cookie = cookies();
	  
	- cookie.set({
		  'sessionId': session.id,
		  'expiresAt': session.expiresAt,
	  });
	  
```

---
### Create Sign-In Route

**Frontend Logic**

```

```

**Business Logic**

```
function signIn(email, password):

	Step 1: Validate form data
	- if validation fails: throw error;
	
	Step 2: Validate if user exists and passwords match
	- user = db.users.findByEmail(email);
	- if users is None || user.password != hash(password): throw error;
	  
	Step 3: Create Session
	- createSessionAndCookie(user.id);
	  
	Step 4: Redirect user to protected route
	- redirect("/protectedRoute");
	  
```

---



