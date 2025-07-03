

|Use `Runnable` when:|Use `Callable` when:|
|---|---|
|You don’t need a result|You need to return a value from your task|
|You don’t need to handle checked exceptions|You need to handle checked exceptions|
|Simple fire-and-forget tasks (logging, printing)|Tasks like database queries, file processing, etc.|
