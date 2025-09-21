
`import type { Hotel } from "@types/hotel"`; means “Bring in only the type information for Hotel, don’t generate any runtime import code.”

- It tells TypeScript: “Only import the type information, not any runtime JavaScript code.”
    
- This is useful for interfaces, type aliases, enums (const enums), etc.
    
- At compile time → TypeScript uses it for type checking.
    
- At runtime → it completely disappears from the compiled JavaScript (so no bundle size impact).

- If Hotel is only a type (interface or type alias), bundlers like Webpack, Vite, or ESBuild might try to import code that doesn’t exist, leading to errors or unnecessary imports.
    

  

By using import type, you make it explicit that this is type-only.