# Understanding Backend-to-Frontend APIs

Assuming that our services already speak XML or JSON to each other via HTTP, an obvious option available to us is to have our user interface (UI) interact directly with these APIs. A web-based UI could use JavaScript GET requests to retrieve data, or POST requests to change it. Even for native mobile applications, initiating HTTP communicatins is fairly straightforward.

**There are couple of downsides of this approach:**

1. We have little ability to tailor the responses for different sorts of devices. One solution to this approach is to allow consumers to specify what fields to pull back when they make a request, but this assumes that each service supports this form of interaction.

2. Opening lots of calls directly to services can be quite intensive for mobile devices, and could be very inefficient use of a customer's mobile data plan. Having an API gateway can help here, as you could expose calls that aggregate multiple underlying calls.

Rather than having our UI make API calls, we could have our services provide parts of the UI directly, and then just pull these fragments in to create a UI. A variation of this approach that can work well is to assemble a series of coarser-grained parts of a UI. So rather than creating small widgets, you are assembling entire panes of a thick client application, or perhaps a set of pages for a website. These coarser-grained fragments are served up from server-sde apps that are in turn making the appropriate API calls. For example, perhaps the team that looks after order management serves up all the pages associated with order management. **You still need some sort of assembly layer to pull these parts together. This could be as simple as some server-side templating, or, where each set of pages comes from a different app, perhaps you'll need some smart URI routing.** One of the key advantages of this approach is that the same team that makes changes to the services can also be in charge to those parts of the UI. It allows us to get changes out faster.

Another problem is harder to deal with. Native applications can't render UI components. We could use a hybrid approach and use native applications to serve up HTML components, but this approach has its own downsides. So **if you need a native experience, we will have to fall back to an approach here the frontend application makes API calss and handles the UI itself.** But even if we consider web-only UIs, we still may want very different treatments for different types of devices. Building responsive components can help, of course. Howevern sometimes the capabilities offered by a service do not fi neatly into a widget or a page.

**A common solution to the problem of chatty interfaces with backend services, or the need to vary content for different types of devices, is to hav a server-side aggregation endpoint, or API gateway.** The problem that can occur is that normally we'll have one giant layer for all our services. This leads to everything being thrown in together, and suddenly we start to lose isolation of our various user interfaces, limiting our ability to release them independently. **The solution is to restrict the use of these backends to one specific user interface or application. This pattern is sometimes referred to as `backends for frontends (BFFs)`.**

BFFs allow the team focusing on any given UI to also handle its own server-side components. Some types of UI may need a minimal server-side footprint, while others may need a lot more. If you need an API authentication and authorization layer, this can sit between our BFFs and our UIs.

> NOTE: BFFs should only contain behavior specific to delivering a particular user experience.
