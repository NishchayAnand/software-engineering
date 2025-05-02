---

---

We need to design a **minimal**, **responsive**, and **user-friendly** frontend interface that allows users to quickly shorten URLs, view their shortened links, and manage them if signed in.

---
### Functional Requirements

The UI would primarily consist of the following screens:

<span style="color:green;"><strong>Landing Page:</strong></span> Centered interface where users can input a long URL and click a `Shorten URL` button to generate a short link. Once the URL is shortened, it is immediately displayed with a `Copy` button for easy sharing. The page should include a simple header with branding and optional `Sign In` / `Sign Up` links, along with a minimal footer containing legal information.

<span style="color:green;"><strong>User Dashboard (for logged-in users):</strong></span> Presents a list view of all URLs the user has shortened. Each item shows the original URL, the corresponding short URL, and the number of times it has been accessed. Users can easily copy or delete any link from this dashboard. The dashboard header should include the logo on the left and a user avatar (profile dropdown) on the right, providing access to user options and logout.

---
### Non-Functional Requirements

1. **SEO:** Use **Server-Side Rendering (SSR)** for publicly accessible pages like the <span style="color:green">landing page</span> to ensure they are easily discoverable and indexable by search engines.

2. **Interactivity:** Use **Client-Side Rendering (CSR)** for authenticated pages like the <span style="color:green">user dashboard</span> to update dynamic UI updates.

3. **Low Latency:** Leverage **Content Delivery Networks (CDNs)** to serve static assets (CSS, JavaScript, images), reducing load times and latency for users worldwide.

4. **Security:** All communication between the client and server must be encrypted using **HTTPS** to ensure data confidentiality and integrity. <span style="color:green;">(talk about rate limiting, XSS, CORS)</span>

---
### Landing Page - UI

The **UI of the landing page** should include the following components:

1. **Header (Navigation Bar):** Contains the application `logo`, navigation links (e.g., `Home`, `About`, `Contact`), and a `login` / `signup` button for user access.

2. **Hero Section:** Displays a brief tagline or mission statement with a `URL input` field and a `Shorten URL` button to instantly generate short links.

3. **Features Section:** Highlights the key benefits of using the service (e.g., fast redirects, analytics, reliability) using icons or illustrations.

4. **Footer:** Includes site links (Privacy Policy, Terms of Service) and the contact information.

<span style="color:green">(Add a Feature Section and a dotted box in the wireframe below to display the generation short URL)</span>

![landing-page](tiny-url-landing-page.svg)

---
### Landing Page - Data Model

The **data model of the landing page** would primarily include the following UI state variables:

1. `longURL`: stores the user-entered long URL.
2. `shortURL`: holds the generated short URL returned by the backend.
3. `isLoading`: a boolean flag indicating if the shortening request is in progress.
4. `error`: captures any validation or server-side errors.

<span style="color:green">(Add a state based wireframe)</span>

> **NOTE:** This state can be managed using React's `useState` and updated in response to user actions like input, form submission, and copy-to-clipboard interaction. 

---
### Landing Page - Data Flow

Here’s how the data should flow through the system when a user interacts with the landing page:

1. **Initial State Load:** When the landing page is first loaded, the initial state consists of the basic UI elements, including the input fields (for entering the long URL) and a button to generate the short URL.

2. **User Input Handling (Long URL):** The user enters a long URL into the input field. As soon as the user types, this triggers an event to update the `longURL` state.

3. **URL Validation:** When the user finish entering the long URL, the app checks if it is a valid URL format. If it’s not valid and updates the `error` state with an error message. This triggers a re-render to display the error.

4. **Submit URL Request (Generate Short URL):** Upon successful validation, the user clicks the `Shorten URL` button. A request is made to the backend via an API call, where the long URL is sent for shortening. The UI shows a loading state (such as a `spinner` or a `Processing...` message) while waiting for the response.

5. **URL History <span style="color:green"><strong>(Optional for Later Sessions)</strong></span>:** If the application supports saving the history of generated short URLs for logged-in users, it stores this history in the backend.

<span style="color:green">(Add a component architecture)</span>

---
### User Dashboard - UI

---
### User Dashboard - Data Model

If user preferences or login state were involved, **`useContext`** or a global store like **Redux**, or **Recoil** could be considered.

---
### User Dashboard - Data Flow

---
### React Components - JavaScript Implementation

---
### EXTRA

