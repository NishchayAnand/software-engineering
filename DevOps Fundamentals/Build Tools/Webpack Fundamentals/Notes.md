# Webpack 5 Fundamentals

Webpack is a powerful **build tool** for creating JavaScript applications.

> **Build Tool**: A software that automates the process of transforming source code into a usable and deployable form.

A **build process** typically involves:

- **compiling** the source code into machine-understandable form or version,
- **packaging** the compiled code into minified and optimized bundles.

## Creating a Simple Build

To install the latest release, run the following command in your terminal:

```
>> npm install --save-dev webpack
```

> It's suggested that you install Webpack with `--save-dev` option since you do not want to include it in your production build.

At its core, webpack is a static **module bundler** that can bundle your JavaScript project for usage in a browser.

> **Module**: Imagine your web application as a big puzzle with many connected pieces. Each piece could be a separate file containing code for a specific functionality, like a button, a form, or a data visualization. These pieces are called modules.
>
> **Bundler**: When you run your application in a browser, it needs all these pieces together to work properly. Webpack acts as the assembler, taking all your individual modules and combining them into one or more optimized bundles.

To bundle your JavaScript project, run the following command in your terminal:

```
>> npx webpack
```

By default, webpack looks for the project's source code in the `./src` folder, but this can be customized using the _entry_ configuration option in the webpack configuration file.

> Webpack can function without a configuration file, but it's common to use a file named `webpack.config.js` to customize its behavior for specific project needs.

When webpack processes your application, it internally builds a dependency graph from one or more _entry_ points and then combines every module your project needs into one or more bundles, which are static assets to serve your content from.
