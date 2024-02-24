# Webpack 5 Fundamentals

Webpack is a powerful **build tool** for creating JavaScript applications.

> **Build Tool**: A software that automates the process of transforming source code into a usable and deployable form.

A **build process** typically involves:

- **compiling** the source code into machine-understandable form or version,
- **packaging** the compiled code into minified and optimized bundles.

## Creating Builds with Webpack

**(continue from here)**

At its core, webpack is a static **module bundler** for modern JavaScript applications.

> **Module**: Imagine your web application as a big puzzle with many connected pieces. Each piece could be a separate file containing code for a specific functionality, like a button, a form, or a data visualization. These pieces are called modules.

> **Bundler**: When you run your application in a browser, it needs all these pieces together to work properly. Webpack acts as the assembler, taking all your individual modules and combining them into one or more optimized bundles.

When webpack processes your application, it internally builds a dependency graph from one or more _entry points_ and then combines every module your project needs into one or more bundles, which are static assets to serve your content from.

**Beyond JavaScript**: While primarily focused on JavaScript, Webpack can also bundle other assets like CSS, images, and fonts. It uses **loaders** to understand and process these different file types.

> Since version 4.0.0, webpack does not require a configuration file to bundle your project. Nevertheless, it is incredibly configurable to better fit your needs.
