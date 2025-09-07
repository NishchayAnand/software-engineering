
When you don't know the exact route segment names ahead of time and want to create routes from dynamic data, you can use Dynamic Segments that are filled in at request time or prerendered at build time.

**Behavior**

Since the `params` prop is a promise. You must use `async`/`await` or React's use function to access the values. 

In version 14 and earlier, `params` was a synchronous prop. To help with backwards compatibility, you can still access it synchronously in Next.js 15, but this behavior will be deprecated in the future.

**Syntax**

A Dynamic Segment can be created by wrapping a folder's name in square brackets: `[folderName]`. 

For example, a blog could include the following route `app/blog/[slug]/page.js` where `[slug]` is the Dynamic Segment for blog posts.

```
// JavaScript

export default async function Page({ params }) {
  const { slug } = await params
  return <div>My Post: {slug}</div>
}

// Typscript

export default async function Page({
  params,
}: {
  params: Promise<{ slug: string }>
}) {
  const { slug } = await params
  return <div>My Post: {slug}</div>
}
```

Dynamic Segments are passed as the `params` prop to [`layout`](https://nextjs.org/docs/app/api-reference/file-conventions/layout), [`page`](https://nextjs.org/docs/app/api-reference/file-conventions/page), [`route`](https://nextjs.org/docs/app/api-reference/file-conventions/route), and [`generateMetadata`](https://nextjs.org/docs/app/api-reference/functions/generate-metadata#generatemetadata-function) functions.

### In Client Components

In a Client Component **page**, dynamic segments from props can be accessed using the [`use`](https://react.dev/reference/react/use) hook.

```
'use client'
import { use } from 'react'
 
export default function BlogPostPage({
  params,
}: {
  params: Promise<{ slug: string }>
}) {
  const { slug } = use(params)
 
  return (
    <div>
      <p>{slug}</p>
    </div>
  )
}
```

Alternatively Client Components can use the [`useParams`](https://nextjs.org/docs/app/api-reference/functions/use-params) hook to access the `params` anywhere in the Client Component tree.

---
### References

1. https://nextjs.org/docs/app/api-reference/file-conventions/dynamic-routes


