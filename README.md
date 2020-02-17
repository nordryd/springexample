# springexample
An example of Spring to present to un-springwoke, jackson, boomer co-workers 🍍🍍🍍

### Notes for Self
_EXAMPLE MUST DO THE FOLLOWING_:
- Use Spring instead of Jax with Maven (obvi)
- Deploy to docker (have the project, project-war, project-test schema)
- Handle errors when thrown (500s should _never_ be thrown intentionally)
- Endpoints must be hittable in docker
- Connect to and interact with Oracle sql
- work with cucumber tests
- generate apis with swagger and openapi
- do I need to worry about oauth? I feel like that's handled by the endpoint and app itself and not spring

_BEFORE DEMO_:
- Make sure you have a base repo/branch you can pull from that is protected from pushes/force pushes
- Make a branch/fork and work with that
- Practice and have a general gameplan
- Be ready to answer any questions people might ask. Try to predict what questions will be asked and have answers ready.

_REASONS TO SWITCH_:
- IT DOES NOT USE EXCLUSIVELY XML! IT CAN BE DONE (AND DONE FLUENTLY, INTUITIVELY, & CLEANLY) WITH PURE JAVA!!!
- DEPENDENCY INJECTION (@Autowired and shit)
	- makes testing easier (no need for @VisibleForTesting)
    - config worries about impls (or let Spring worry about it by using BEANS
    - IE explicit `new` declarations are done in the config and the code itself just pulls from the config using spring's 
    `BeanFactory`
