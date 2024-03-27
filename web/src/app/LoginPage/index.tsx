import Image from 'next/image';

import AppLogo from '../../public/assets/AppLogo.svg';

export default function LoginPage() {
    return (
      <main>
        <section className="flex w-screen h-screen flex-col justify-center items-center">

            <div className=""> 
                <Image
                    src={AppLogo}
                    height={250}
                    width={250}
                    alt="SyncTask" />

                <h2> Bem-vindo ao SyncTask! </h2>
            </div>

            <div>
                <h2> LOGIN </h2>
                <form action="" id="LoginForm">
                    <div className="flex flex-col">
                        <input type="text" placeholder="Insira o seu Email" required />

                        <input type="text" placeholder="Insira a sua senha" required />

                        <input type="submit" value="Entrar" form="LoginForm" />
                    </div>

                    <div>
                        <p> Esqueceu a senha? <a href="#">Clique aqui</a></p>

                        <p> Não tem conta? <a href="#">Clique aqui</a></p>
                    </div>
                </form>
            </div>
        </section>
      </main>
    );
  }