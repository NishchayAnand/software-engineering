
The Next.js Image component extends the HTML `<img>` element for automatic image optimization.

It’s essentially a drop-in replacement for <img>, but with built-in performance optimizations like lazy loading, responsive sizes, and automatic image formats.

```
import Image from 'next/image'
 
export default function Page() {
  return (
    <Image
      src="/profile.png"
      width={500} // default unit = px
      height={500} // default unit = px
      alt="Picture of the author"
    />
  )
}
```

> **NOTE:** `width` and `height` are required unless you use `fill`.

---
### Response Image with `fill`

`fill`: A boolean that causes the image to expand to the size of the parent element. Use this, if you want the image to scale to its parent container (e.g., full-width banners). 

The parent element must assign `position: "relative"`, `"fixed"`, `"absolute"`. By default, the `<img>` element uses `position: "absolute"`.

If no styles are applied to the image, the image will stretch to fit the container. Though, you can use `objectFit` property to control cropping and scaling:

- `"contain"`: The image will be scaled down to fit the container and preserve aspect ratio.
- `"cover"`: The image will fill the container and be cropped.

```
<div className="relative w-full h-64">
  <Image
    src="/banner.jpg"
    alt="Hotel Banner"
    fill={true}
    className="object-cover"
  />
</div>
```

> **NOTE:** `fill` makes the image expand to its **parent container (must be relative + width/height set)**.

---

It’s optimized for performance and automatically handles things like:

- **Image optimization** (resizing, compressing, and serving modern formats like WebP).
- **Responsive images** (different sizes for different screen widths).
- **Lazy loading** (images outside the viewport load only when scrolled into view).
- **CDN delivery** (images can be cached and served efficiently).

---
### Common Props and their Use Cases

`loader`: A custom function used to generate the image URL.

```
import Image from 'next/image'
 
const imageLoader = ({ src, width, quality }) => {
  return `https://example.com/${src}?w=${width}&q=${quality || 75}`
}
 
export default function Page() {
  return (
    <Image
      loader={imageLoader}
      src="me.png"
      alt="Picture of the author"
      width={500}
      height={500}
    />
  )
}
```

---
