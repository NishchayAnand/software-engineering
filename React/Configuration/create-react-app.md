# Understanding create-react-app

`create-react-app` is a tool for building SPAs with a standard structure and a good set of default options. Generated projects use the **React Scripts library** to **build**, **test**, and **run** the code.

It is simple to use and contains all the features that a typical application requires: from **Babel** configuration and file loaders to testing libraries and a **development server**.

You don’t need to manage a list of **Babel** plugins or **postcss** libraries, or maintain a complex `webpack.config.js` file. The **react-scripts** library manages them all for you.

> **NOTE: The configuration is all still there, of course, but buried deep within the react-scripts directory. In there, you will find the `webpack.config.js` file, containing all the Babel configuration and file loaders that your application will use.**

You can choose to install the `create-react-app` command globally on your machine, but this is now discouraged. Instead, you should create a new project by calling `create-react-app` via `npx`. Using npx ensures you’re building your application with the latest version of create-react-app.

```
>> npx create-react-app my-app
```

> NOTE:

The code mounts all of its components inside `<div id="root"></div>` in `public/index.html`.

The code to generate the components begins in the `src/index.js` file.

```
import React from 'react'
import ReactDOM from 'react-dom'
import './index.css'
import App from './App'
import reportWebVitals from './reportWebVitals'

ReactDOM.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
)

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals()
```

This file does little more than render a single component called `<App/>`, which it imports from `App.js` in the same directory.
