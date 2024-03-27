import Image from 'next/image';
import AppLogo from '../../public/assets/AppLogo.svg';

export default function LoginPage() {
    return (
        <main>
            <section className="flex w-screen h-screen flex-col justify-center items-center">

                <div className="">
                    <Image
                        src={AppLogo}
                        height={150}
                        width={150}
                        alt="SyncTask"
                        className="flex my-5"
                    />

                    <h2 className="font-bold mb-4"> Bem-vindo ao SyncTask! </h2>
                </div>

                <div>
                    <h2 className="inline-block font-bold tracking-wider border-b-4 border-purple-400 mb-2"> LOGIN </h2>
                    <form action="" id="LoginForm" className="w-full max-w-md">
                        <div className="flex flex-col">
                            <input
                                type="text"
                                placeholder="Insira o seu email"
                                required
                                className="w-full p-2 border-4 border-purple-400 rounded-xl font-bold mb-4"
                            />

                            <input
                                type="text"
                                placeholder="Insira a sua senha"
                                required
                                className="w-full p-2 border-4 border-purple-400 rounded-xl font-bold bg-transparent"
                            />

                            <div className="flex justify-end w-full">
                                <input
                                    type="submit"
                                    value="Entrar"
                                    form="LoginForm"
                                    className="w-28 h-8 mt-3 border-transparent rounded-xl font-bold bg-notation-yellow text-purple-500"
                                />
                            </div>
                        </div>

                        <div className="inline-block justify-between mt-4">
                            <p> Esqueceu a senha? <a href="#" className="text-purple-400 font-semibold">Clique aqui</a></p>
                            <p> Não tem conta? <a href="#" className="text-purple-400 font-semibold">Clique aqui</a></p>
                        </div>
                    </form>
                </div>
            </section>
        </main>
    );
}
