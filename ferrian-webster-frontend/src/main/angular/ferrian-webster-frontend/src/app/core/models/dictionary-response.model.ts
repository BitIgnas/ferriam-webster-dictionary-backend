import { Meaning } from "./meaning.model";
import { Phonetic } from "./phonetic.model";

export interface DictionaryResponse {
    word: string;
    phonetic: string;
    phonetics: Array<Phonetic>;
    origin: string;
    meanings: Array<Meaning>; 
}