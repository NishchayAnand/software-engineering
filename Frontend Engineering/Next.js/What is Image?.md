
The Next.js Image component extends the HTML `<img>` element for automatic image optimization.

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

---
### Common Props and their Use Cases

`fill`: A boolean that causes the image to expand to the size of the parent element.

```
<Image src="/profile.png" fill={true} />
```

`position`: The parent element must assign `position: "relative"`, `"fixed"`, `"absolute"`. By default, the `<img>` element uses `position: "absolute"`.

`objectFit`: If no styles are applied to the image, the image will stretch to fit the container. You can use `objectFit` to control cropping and scaling.

- `"contain"`: The image will be scaled down to fit the container and preserve aspect ratio.
- `"cover"`: The image will fill the container and be cropped.

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
