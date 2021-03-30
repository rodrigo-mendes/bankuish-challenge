# Bankuish Code Challenge

## Initial information - CEO Notes
![Challenge](doc/images/CHALLENGE.png)

## Initial Thoughts
>  Create a new feature adding popularity to the characters retrieve from an external API.

### Key points
* All request need to be stored, to further analyze about users intention and behavior.
* The original api don't have any information about popularity
* The character's will be chosen at random

> Objective is aggregate som information in the original data 

### First Draft
In this first design will be based on building blocks, each one with your own responsibility.

![Draft](doc/images/draft_v1.jpg)

| Component | Responsibility | Comments |
| ----------- | ----------- | ----------- |
| Request Store |  Store all request made from any user | It's not a feature component, will be use to understand a client behaviour. |
| ID generator | Generate random character id's |  |
| Orchestrator | Will be implement all business logic needed to complete a task |  |
| Popularity API | Component to manager a popularity of all characters, storing information to identify each character and his popularity index.  | 30/03 - After discussions to deepen the requirement, consensus was reached on the use of an external API.  |

### Gathering Information

#### Interactions

##### Questions & Answers

Q: As I understand it, I have an operation that is to collect requests, another that is to retrieve 5 random characters, these two are clear, now that it gets a little confused, the exclusion of characters when I can do this?
> A: The microservice will expose only one endpoint which will allow the user to retrieve up to 5 random rick and morty characters. The user can exclude by characterId any number of characters. The excluded list should be sent in the request.
Also we have to store the requests to analyze them later on. The implementation details are up to you, anything that provides this functionality is ok.

Q: And finally how do I calculate the popularity of the characters? Are they based on the number of times they return? Or another way?
> A: We can't calculate the popularity, so we have to integrate with a third party that offers this information. We don't have the specification of their API yet but we know that will be a REST API and probably they are storing the popularity associated with the same id that we are using.

Q: And should exclusion affect popularity? For example when chosen it adds one and when it subtracted a point.
> A: No, the exclusion doesn't affect the popularity.

#### Conclusions and Thoughts
After compiling all the doubts and some more interactions with the CEO and his team, all the open points in our interpretation that we had raised to create a draft of the solution, as a first interaction even the possibility of a Proof of Concept, to have a first idea of what the application would look like to show a technical solution to prove and test some ideas. Just as we have drafts for drawings I am a supporter who could have a draft of the software too.

### Proof of Concepts

#### Design considerations

* Microservice infrastructure not defined, then could be using a port adapter approach. That could be maintained design decisions, creating consistent interfaces.
* There are two different ways to consume the API, an abstraction layer should be created so that the technology chosen today, for example, for reasons of proof of concepts, does not affect the choice of the best form of consumption for the real case, creating this layer of abstraction can be alters the implementation of consumption, so we would have an ACL (anti-corruption layer) approach

![Components](doc/images/components_v1.jpg)

| Component | Technology | Motivation | 
| :-----------: | :-----------: | ----------- |
| Request Store      | Servlet filter and SPI (Java service Provider Interface) |  1. **Servlet filter** - it's more robust than Spring interceptors / 2. **SPI** - to create a injection mechanism |
| ID generator       | Java + Spring | For proof need it's enough, but will be using all design considerations with port-adapter approach,  that way could be replace with something more robust |
| Orchestrator       | Java + Spring | As Doug Cutting would say, because I know java. (Answering why Hadoop was programmed in java) |
| Popularity API | Java + Spring | This component will simulate the behavior of a third-party API, which has not yet been defined, it will be a mock implementation to return a popularity index, being sent the character id.|

#### Stack chosen 
> Spring Boot and Spring will be used, because the ease and speed of implementing a proof of concept and that makes a great use of the port-adapter approach.


