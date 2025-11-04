
Usually, you will pass information from a parent component to a child component via props. But passing props can become verbose and inconvenient if you have to pass them through many components in the middle, or if many components in your app need the same information.

**Context** lets the parent component make some information available to any component in the tree below it—no matter how deep—without passing it explicitly through props.

```

```

---
### Create the context

The only argument to `createContext` is the _default_ value.

```
import { createContext } from 'react';

export const LevelContext = createContext(1);
```

---
### Use the context

Currently, the `Heading` component reads `level` from props:

```
export default function Heading({ level, children }) {  
	// ...  
}
```

Instead, remove the `level` prop and read the value from the context you just imported, `LevelContext`:

```
import { useContext } from 'react';  
import { LevelContext } from './LevelContext.js';
```

```
export default function Heading({ children }) {  
	const level = useContext(LevelContext);  
	// ...  
}
```

---
### Provide the context

The `Section` component currently renders its children:

```
export default function Section({ children }) {  
	return (  
		<section className="section">  
			{children}  
		</section>  
	);  
}
```

**Wrap them with a context provider** to provide the `LevelContext` to them:

```
import { LevelContext } from './LevelContext.js';  

export default function Section({ level, children }) {  
	return (  
		<section className="section">  
			<LevelContext value={level}>  
				{children}  
			</LevelContext>  
		</section>  
	);
}
```

This tells React: “if any component inside this `<Section>` asks for `LevelContext`, give them this `level`.” The component will use the value of the nearest `<LevelContext>` in the UI tree above it.

---

