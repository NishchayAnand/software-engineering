Artificial Intelligence (AI) **imitates human behaviour by using machine learning** to interact with the environment and execute tasks without explicit directions on what to output.

**Generative AI:** A category of capabilities within AI that create original content. 

People typically interact with generative AI that has been built into chat applications.

Generative AI applications are powered by **language models**, which are **a specialised type of machine learning model that you can use to perform natural language processing (NLP) tasks**, including:

- Determining sentiment or otherwise classifying natural language text.
- Summarising text.
- Comparing multiple text sources for semantic similarity.
- Generating new natural language.

---
## Transformer Models

Large language models are based on the **transformer architecture**, which **builds on and extends** some techniques that have been proven successful in **modelling vocabularies to support NLP tasks - and in particular in generating language**. 

Transformer models are trained with large volumes of text, enabling them to represent the **semantic relationships between words** and use those relationships to determine probable sequences of text that make sense. 

Transformer models with a large enough vocabulary are capable of generating language responses that are tough to distinguish from human responses.

---
## Transformer Model Architecture 

Transformer model architecture consists of two components, or blocks:

- **Encoder block:** Creates semantic representations of the training vocabulary. Generic workflow:
	- The sequences of text are broken down into tokens (for example, individual words).
	- The encoder block processes these token sequences using a technique called **attention** to determine relationships between tokens (for example, which tokens influence the presence of other tokens in a sequence, different tokens that are commonly used in the same context, and so on).
	- The output from the encoder is a collection of vectors (multi-valued numeric arrays) in which each element of the vector represents a semantic attribute of the tokens. These vectors are referred to as **embeddings**.

- **Decoder block:** Generates new language sequences. For example, given an input sequence like `"When my dog was"`, the model can use the **attention** technique to analyse the input tokens and the semantic attributes encoded in the **embeddings** to predict an appropriate completion of the sentence, such as `"a puppy"`. 

> NOTE: In practice, the specific implementations of the architecture vary – for example, the **Bidirectional Encoder Representations from Transformers (BERT)** model developed by Google to support their search engine uses only the encoder block, while the **Generative Pre-trained Transformer (GPT)** model developed by OpenAI uses only the decoder block.

---
## Tokenisation

Consider the following sentence: `I heard a dog bark loudly at a cat`. To tokenise this text, you can identify each discrete word and assign token IDs to them. For example:

```
- I (1)
- heard (2)
- a (3)
- dog (4)
- bark (5)
- loudly (6)
- at (7)
- ("a" is already tokenized as 3)
- cat (8)
```

The sentence can now be represented with the tokens: {1 2 3 4 5 6 7 3 8}. Similarly, the sentence `"I heard a cat"` could be represented as {1 2 3 8}.

> NOTE: As you continue to train the model, each new token in the training text is added to the vocabulary with appropriate token IDs. With a sufficiently large set of training text, a vocabulary of many thousands of tokens could be compiled.

---
## Word Embeddings

While it may be convenient to represent tokens as simple IDs (e.g., creating an index for all the words in the vocabulary), they don't tell us anything about the meaning of the words, or the relationships between them. 

To create a vocabulary that encapsulates semantic relationships between the tokens, we define **contextual vectors**, known as **embeddings**.

Vectors are multi-valued numeric representations of information, for example [10, 3, 1] in which each numeric element represents a particular attribute of the information.

---
## Vector Databases


