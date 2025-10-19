
The `<Form>` component extends the HTML `<form>` element to provide **prefetching of loading UI**, **client-side navigation** on submission, and **progressive enhancement**.

It's useful for forms that update URL search params as it reduces the boilerplate code needed to achieve the above.

**Syntax**

```
import Form from 'next/form'
 
export default function Page() {
  return (
    <Form action="/search">
      {/* On submission, the input value will be appended to
          the URL, e.g. /search?query=abc */}
      <input name="query" />
      <button type="submit">Submit</button>
    </Form>
  )
}
```

The behavior of the `<Form>` component depends on whether the `action`prop is passed a `string` or `function`.

When `action` is a **string**, the `<Form>` behaves like a native HTML form that uses a **`GET`** method. The form data is encoded into the URL as search params, and when the form is submitted, it navigates to the specified URL. 

In addition, Next.js:

-  [Prefetches](https://nextjs.org/docs/app/getting-started/linking-and-navigating#prefetching) the path when the form becomes visible, this preloads shared UI (e.g. `layout.js` and `loading.js`), resulting in faster navigation.

- Performs a [client-side navigation](https://nextjs.org/docs/app/getting-started/linking-and-navigating#client-side-transitions) instead of a full page reload when the form is submitted. This retains shared UI and client-side state.

When `action` is a **function** (Server Action), `<Form>` behaves like a [React form](https://react.dev/reference/react-dom/components/form), executing the action when the form is submitted. The function passed to `action` may be async and will be called with a single argument containing the [form data](https://developer.mozilla.org/en-US/docs/Web/API/FormData) of the submitted form.

NOTE: When a function is passed to `action` or `formAction` the HTTP method will be POST regardless of value of the `method` prop.